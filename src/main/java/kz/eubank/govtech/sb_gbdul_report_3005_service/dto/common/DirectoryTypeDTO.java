package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DirectoryTypeDTO {
    @Schema(description = "код")
    private String code;
    @Schema(description = "название на русском языке")
    private String nameRu;
    @Schema(description = "название нагосударственном языке")
    private String nameKz;
}
