package kz.eubank.govtech.sb_gbdul_report_3005_service.dto;

import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.request.BaseRequestMessageDTO;
import kz.eubank.govtech.sb_gbdul_report_3005_service.dto.request.RequestTypeDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class RequestDTO extends BaseRequestMessageDTO {
    private RequestTypeDTO businessData;

}
