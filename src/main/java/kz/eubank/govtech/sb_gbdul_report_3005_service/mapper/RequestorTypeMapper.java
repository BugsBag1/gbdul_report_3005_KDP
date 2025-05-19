package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.RequestorDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.RequestorType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CompanyInfoTypeMapper.class})
public interface RequestorTypeMapper {
    @Mapping(source = "organization", target = "organization")
    RequestorType map(RequestorDTO requestorDTO);

    @Mapping(source = "organization", target = "organization")
    RequestorDTO toDTO(RequestorType requestorType);

}
