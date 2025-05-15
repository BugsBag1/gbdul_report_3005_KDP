package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.DirectoryTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.DirectoryType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectoryTypeMapper {
    DirectoryTypeDTO toDTO(DirectoryType directoryType);
}
