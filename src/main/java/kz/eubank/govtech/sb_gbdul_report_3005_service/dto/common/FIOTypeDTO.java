package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FIOTypeDTO {
    @Schema(description = "Фамилия")
    private String surName;
    @Schema(description = "Имя")
    private String name;
    @Schema(description = "Отчество")
    private String middleName;
}
