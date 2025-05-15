package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.FIOTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.FIOType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FIOTypeMapper {
    FIOTypeDTO toDTO(FIOType fioType);
}
