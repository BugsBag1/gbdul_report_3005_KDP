package kz.eubank.govtech.sb_gbdul_report_3005_service.service;

import kz.eubank.govtech.sb_gbdul_report_3005_service.config.AppConfigurator;
import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.RequestDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.ResponseDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.mapper.RequestMapper;
import kz.eubank.govtech.sb_gbdul_report_3005_service.mapper.ResponseMapper;
import kz.eubank.govtech.sb_gbdul_report_3005_service.utils.ChangeNamespacePrefix;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.ObjectFactory;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.RequestMessage;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.ResponseMessage;
import kz.govtech.m11s.syncshepclient.dto.DataResponse;
import kz.govtech.m11s.syncshepclient.exception.BadRequestException;
import kz.govtech.m11s.syncshepclient.exception.DetailedException;
import kz.govtech.m11s.syncshepclient.exception.SignatureException;
import kz.govtech.m11s.syncshepclient.service.AConverter;
import kz.govtech.m11s.syncshepclient.util.SignKeyInfo;
import kz.govtech.m11s.syncshepclient.util.SignatureUtils;
import kz.govtech.m11s.syncshepclient.util.XmlUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class Converter extends AConverter<RequestDTO, RequestMessage, ResponseMessage, ResponseDTO> {
    private final AppConfigurator configurator;

    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;

    @Override
    protected String getServiceId() {
        return configurator.getShepServiceId();
    }

    @Override
    protected QName getRequestQName() {
        return new QName("request");
    }

    @Override
    protected Class<RequestMessage> getServiceRequestClass() {
        return RequestMessage.class;
    }

    @Override
    protected Class<ResponseMessage> getServiceResponseClass() {
        return ResponseMessage.class;
    }

    @Override
    protected Element signElement(final Element element) {
        try {
            Element targetElement = (Element) element.getFirstChild();
            if (this.getSignKeyInfo() != null){
                Element signedElement = SignatureUtils.signXmlElement(targetElement, this.getSignKeyInfo());
            } else {
                return element;
            }


            return element;
        } catch (SignatureException var3) {
            throw new DetailedException(HttpStatus.INTERNAL_SERVER_ERROR, "Error signing request data");
        }
    }

    @Override
    protected Element marshalRequest(final RequestMessage request) {
        JAXBElement<RequestMessage> jaxbElement = this.createJaxbElement(request);
        Document requestDoc = this.createDocument(jaxbElement);
        Element dataElement = this.transformDataElement(requestDoc);
        dataElement = this.signElement(dataElement);
        return dataElement;
    }

    @Override
    protected SignKeyInfo getSignKeyInfo() {
        return new SignKeyInfo(
            configurator.getShepSignKeyPath(),
            configurator.getShepSignKeyPass(),
            configurator.getShepSignKeyType()
        );
    }

    @Override
    protected RequestMessage convertToServiceRequest(RequestDTO requestDto) {
        return requestMapper.map(requestDto);
    }

    @Override
    protected JAXBElement<RequestMessage> createJaxbElement(final RequestMessage request) {
        ObjectFactory objectFactory = new ObjectFactory();
        return objectFactory.createRequest(request);
    }

    @Override
    protected Element transformDataElement(final Document document) {
        Element rootElement = document.getDocumentElement();
        if (rootElement.getTagName().equalsIgnoreCase("data")) {
            return rootElement;
        }
        Element dataElement = document.createElement("data");
        dataElement.appendChild(rootElement);

//        this.changeRootElementAttribute(dataElement, this.getRequestQName().getLocalPart(), this.getRequestQName().getNamespaceURI());

        return dataElement;
    }

    @Override
    protected Marshaller getRequestMarshaller() throws JAXBException {
        Marshaller marshaller = this.requestJaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new ChangeNamespacePrefix());
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", false);
        return marshaller;
    }

    @Override
    protected Document createDocument(final JAXBElement<RequestMessage> jaxbElement) {
        Document document;
        try {
            DocumentBuilder documentBuilder = XmlUtils.getDocumentBuilder();
            document = documentBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            throw BadRequestException.createDataIsIncorrect();
        }

        try {
            Marshaller marshaller = this.getRequestMarshaller();
            marshaller.marshal(jaxbElement, document);
            Element rootElement = document.getDocumentElement();
            rootElement.setAttributeNS("http://www.w3.org/2000/xmlns/",
                "xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
            return document;
        } catch (JAXBException e) {
            throw new DetailedException(HttpStatus.INTERNAL_SERVER_ERROR, "Error marshalling request");
        }
    }

    @SneakyThrows
    @Override
    protected ResponseDTO convertToApiResponse(ResponseMessage response) {
        return responseMapper.toDTO(response);
    }

    public ResponseDTO processCreateResponse(DataResponse dataResponse) {
        if (dataResponse == null || dataResponse.getData() == null) return null;

        Element dataElement = dataResponse.getData();
        Optional<Element> firstElementOpt = findFirstElement(dataElement);

        if (firstElementOpt.isPresent()) {
            ResponseMessage parsed = extractResponseFromElement(firstElementOpt.get());
            return convertToApiResponse(parsed);
        } else {
            String textXml = extractTextContent(dataElement);
            if (textXml != null && !textXml.trim().isEmpty()) {
                ResponseMessage parsed = unmarshalFromXmlString(textXml);
                return convertToApiResponse(parsed);
            }
        }

        return createResponse(dataResponse);
    }


    private Optional<Element> findFirstElement(Element dataElement) {
        NodeList children = dataElement.getChildNodes();
        Element firstElement = null;

        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                if (firstElement != null) {
                    return Optional.empty();
                }
                firstElement = (Element) children.item(i);
            }
        }
        return Optional.ofNullable(firstElement);
    }

    public ResponseMessage extractResponseFromElement(Element element) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(element), new StreamResult(writer));
            String responseXml = writer.toString();

            JAXBContext jaxbContext = JAXBContext.newInstance("kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<ResponseMessage> jaxbElement = (JAXBElement<ResponseMessage>)
                unmarshaller.unmarshal(new StringReader(responseXml));

            return jaxbElement.getValue();

        } catch (Exception e) {
            log.error("Ошибка при разборе XML: ", e);
        }
        return null;
    }

    private String extractTextContent(Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE || node.getNodeType() == Node.CDATA_SECTION_NODE) {
                return node.getTextContent();
            }
        }
        return null;
    }

    private ResponseMessage unmarshalFromXmlString(String xml) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<ResponseMessage> jaxbElement = (JAXBElement<ResponseMessage>)
                unmarshaller.unmarshal(new StringReader(xml));

            return jaxbElement.getValue();

        } catch (Exception e) {
            log.error("Ошибка при разборе текстовой XML-строки: ", e);
            return null;
        }
    }
}
