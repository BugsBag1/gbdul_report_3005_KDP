package kz.govtech.m11s.sb_gbdul_report_3005_service.mapper;

import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.common.RegisterDealDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.xsd.RequestAndResponse.RegisterDeal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterDealMapper {
    RegisterDealDTO toDto(RegisterDeal registerDeal);
}
