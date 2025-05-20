package kz.govtech.m11s.sb_gbdul_report_3005_service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.common.OrganizationTypeDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.common.RegisterDealDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.common.RequestorDTO;
import lombok.Data;

import java.util.List;

@Data
public class ResponseTypeDTO {
    @Schema(description = "Номер справки. Дата определяется по дате сообщения")
    private String reportNumber;
    @Schema(description = "Сведения об организации для выдачи справки")
    private OrganizationTypeDTO organization;
    @Schema(description = "Сведения о регдействиях")
    private List<RegisterDealDTO> registerDeals;
    @Schema(description = "Заявитель (используется для отображения в выходном документе на ПЭП)")
    private RequestorDTO requestor;
}
