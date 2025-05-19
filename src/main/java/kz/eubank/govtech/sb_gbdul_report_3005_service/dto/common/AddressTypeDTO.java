package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddressTypeDTO {
    @Schema(description = "Код адресного ресурса")
    private String rka;
    @Schema(description = "Адрес на русском языке")
    private String nameRu;
    @Schema(description = "Адрес на государственном языке")
    private String nameKz;
}
