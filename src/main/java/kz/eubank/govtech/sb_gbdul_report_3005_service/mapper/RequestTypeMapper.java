package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.InfoAbtTokenDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.TokenInfoDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.request.RequestTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.InfoAbtToken;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.RequestType;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.TokenInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RequestorTypeMapper.class})
public interface RequestTypeMapper {

    @Mapping(source = "requestor", target = "requestor")
    @Mapping(source = "bin", target = "BIN")
    RequestType map(RequestTypeDTO requestTypeDTO);

    InfoAbtToken mapInfoAbtToken(InfoAbtTokenDTO infoAbtTokenDTO);

    TokenInfo mapTokenInfo(TokenInfoDTO tokenInfoDTO);

    List<TokenInfo> mapTokenInfoList(List<TokenInfoDTO> tokenInfoDTOList);
}
