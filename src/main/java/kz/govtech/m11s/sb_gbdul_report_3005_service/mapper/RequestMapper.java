package kz.govtech.m11s.sb_gbdul_report_3005_service.mapper;

import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.RequestDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.xsd.RequestAndResponse.RequestMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RequestTypeMapper.class})
public interface RequestMapper {
    @Mapping(source = "businessData", target = "businessData")
    RequestMessage map(RequestDTO requestDTO);
}
