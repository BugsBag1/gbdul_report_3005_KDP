package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.response.ResponseTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.ResponseType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring"
    , uses = {OrganizationTypeMapper.class
    , RegisterDealMapper.class
    , RequestMapper.class})
public interface ResponseTypeMapper {
    @Mapping(source = "organization", target = "organization")
    @Mapping(source = "registerDeals", target = "registerDeals")
    @Mapping(source = "requestor", target = "requestor")
    ResponseTypeDTO toDTO(ResponseType responseType);
}
