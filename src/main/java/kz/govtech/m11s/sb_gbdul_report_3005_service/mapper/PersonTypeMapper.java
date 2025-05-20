package kz.govtech.m11s.sb_gbdul_report_3005_service.mapper;

import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.common.PersonTypeDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.xsd.RequestAndResponse.PersonType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FIOTypeMapper.class})
public interface PersonTypeMapper {
    @Mapping(source = "FIO", target = "fio")
    @Mapping(source = "IIN", target = "iin")
    PersonTypeDTO toDto(PersonType personType);
}
