package kz.govtech.m11s.sb_gbdul_report_3005_service.mapper;

import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.common.DirectoryTypeDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.xsd.RequestAndResponse.DirectoryType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectoryTypeMapper {
    DirectoryTypeDTO toDTO(DirectoryType directoryType);
}
