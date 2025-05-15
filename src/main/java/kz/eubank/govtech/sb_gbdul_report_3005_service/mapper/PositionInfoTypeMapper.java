package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.PositionInfoTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.PositionInfoType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionInfoTypeMapper {
    PositionInfoTypeDTO toDto(PositionInfoType position);
}
