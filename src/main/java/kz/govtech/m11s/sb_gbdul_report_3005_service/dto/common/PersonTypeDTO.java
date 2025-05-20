package kz.govtech.m11s.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PersonTypeDTO {
    @Schema(description = "ФИО")
    private FIOTypeDTO fio;
    @Schema(description = "ИИН")
    private String iin;
}
