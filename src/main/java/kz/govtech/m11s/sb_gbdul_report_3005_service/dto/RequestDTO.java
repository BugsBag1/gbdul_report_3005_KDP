package kz.govtech.m11s.sb_gbdul_report_3005_service.dto;

import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.request.BaseRequestMessageDTO;
import kz.govtech.m11s.sb_gbdul_report_3005_service.dto.request.RequestTypeDTO;
import lombok.Data;


@Data
public class RequestDTO extends BaseRequestMessageDTO {
    private RequestTypeDTO businessData;

}
