package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterDealDTO {
    @Schema(description = "Код регдействия")
    private String registerDealTypeId;
    @Schema(description = "Название регдейстаһвия на русском")
    private String registerDealTypeNameRu;
    @Schema(description = "Название регдействия на государственном")
    private String registerDealTypeNameKz;
    @Schema(description = "Дата регдействия")
    private LocalDate registerDealTypeDate;
    @Schema(description = "Комментарий к регдействию  на русском(вывести в скобках после названия регдействия)")
    private String noticeRu;
    @Schema(description = "Комментарий к регдействию  на государственном (вывести в скобках после названия регдействия)")
    private String noticeKz;
}
