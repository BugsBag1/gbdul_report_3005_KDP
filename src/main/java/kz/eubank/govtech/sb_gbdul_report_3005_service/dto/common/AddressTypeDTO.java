package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddressTypeDTO {
    @Schema(description = "код адресного ресурса")
    private String rka;
    @Schema(description = "адрес на русском языке")
    private String nameRu;
    @Schema(description = "адрес нагосударственном языке")
    private String nameKz;
}
