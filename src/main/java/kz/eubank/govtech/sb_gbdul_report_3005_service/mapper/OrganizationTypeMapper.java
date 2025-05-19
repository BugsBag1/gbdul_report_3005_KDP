package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.OrganizationTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.OrganizationType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
    DirectoryTypeMapper.class,
    PersonLeaderTypeMapper.class,
    OrganizationShortTypeMapper.class,
    PersonTypeMapper.class,
    AddressTypeMapper.class
})
public interface OrganizationTypeMapper {
    @Mapping(source = "BIN", target = "bin")
    @Mapping(source = "registrationDepartment", target = "registrationDepartment")
    @Mapping(source = "organizationLeader", target = "organizationLeader")
    @Mapping(source = "foundersUL", target = "foundersUL")
    @Mapping(source = "foundersFL", target = "foundersFL")
    @Mapping(source = "headerOrganization", target = "headerOrganization")
    @Mapping(source = "legalAddress", target = "legalAddress")
    OrganizationTypeDTO toDto(OrganizationType organizationType);
}
