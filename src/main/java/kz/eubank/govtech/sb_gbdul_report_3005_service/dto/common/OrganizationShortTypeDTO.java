package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrganizationShortTypeDTO {
    @Schema(description = "Наименование организации на русском языке")
    private String organizationNameRu;
    @Schema(description = "Наименование организации на государственном языке")
    private String organizationNameKz;
    @Schema(description = "БИН")
    private String bin;

}
