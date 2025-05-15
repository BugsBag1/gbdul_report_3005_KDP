package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.OrganizationShortTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.OrganizationShortType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationShortTypeMapper {
    OrganizationShortTypeDTO toDto(OrganizationShortType organizationShortType);
}
