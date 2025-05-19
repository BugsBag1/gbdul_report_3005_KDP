package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PositionInfoTypeDTO {
    @Schema(description = "Наименование должности на русском языке")
    private String nameRu;
    @Schema(description = "Наименование должности на государственном языке")
    private String nameKz;
    @Schema(description = "Дата назначения")
    private LocalDate appointmentDate;
    @Schema(description = "Сведения об отстранении от должности или утрате силы назначения управляющего на русском языке")
    private String addInfoRu;
    @Schema(description = "Сведения об отстранении от должности или утрате силы назначения управляющего на государственном языке")
    private String addInfoKz;

}
