package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.StatusTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.StatusType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusTypeMapper {
    StatusTypeDTO toDTO(StatusType statusType);
}
