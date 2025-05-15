package kz.eubank.govtech.sb_gbdul_report_3005_service.utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class XmlDateUtils {

    public static OffsetDateTime convertToOffsetDateTime(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return null;
        }
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
    }

    public static XMLGregorianCalendar convertToXMLGregorianCalendar(OffsetDateTime localDateTime) {
        if (localDateTime == null) {return null;}
        try {
            GregorianCalendar gregorianCalendar = GregorianCalendar.from(localDateTime.atZoneSameInstant(ZoneId.systemDefault()));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Ошибка при конвертации LocalDateTime в XMLGregorianCalendar", e);
        }
    }

    public static LocalDate convertToLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) { return null; }
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

    public static XMLGregorianCalendar convertToXMLGregorianCalendar(LocalDate localDate) {
        if(localDate == null){
            return null;
        }
        try {
            GregorianCalendar gregorianCalendar = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Ошибка при конвертации LocalDate в XMLGregorianCalendar", e);
        }
    }
}
