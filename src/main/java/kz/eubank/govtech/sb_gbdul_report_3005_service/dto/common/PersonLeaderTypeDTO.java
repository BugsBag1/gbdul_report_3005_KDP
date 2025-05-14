package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PersonLeaderTypeDTO {
    @Schema(description = "ФИО")
    private FIOTypeDTO fio;
    @Schema(description = "Должность")
    private PositionInfoTypeDTO positionInfo;
    @Schema(description = "ИИН")
    private String iin;
}
