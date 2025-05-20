package kz.govtech.m11s.sb_gbdul_report_3005_service.mapper;

import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.ResponseDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.xsd.RequestAndResponse.ResponseMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
    StatusTypeMapper.class,
    ResponseTypeMapper.class
})
public interface ResponseMapper {
    @Mapping(source = "businessData", target = "businessData")
    ResponseDTO toDTO(ResponseMessage response);
}
