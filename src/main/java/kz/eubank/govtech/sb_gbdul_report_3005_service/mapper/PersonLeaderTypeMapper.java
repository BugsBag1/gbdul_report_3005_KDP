package kz.eubank.govtech.sb_gbdul_report_3005_service.mapper;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common.PersonLeaderTypeDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.xsd.RequestAndResponse.PersonLeaderType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring"
    , uses = {FIOTypeMapper.class
    , PositionInfoTypeMapper.class})
public interface PersonLeaderTypeMapper {
    @Mapping(source = "FIO", target = "fio")
    @Mapping(source = "positionInfo", target = "positionInfo")
    @Mapping(source = "IIN", target = "iin")
    PersonLeaderTypeDTO toDTO(PersonLeaderType personLeaderType);
}
