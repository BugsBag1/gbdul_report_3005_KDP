package kz.eubank.govtech.sb_gbdul_report_3005_service.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoteError {
    private String errorCode;
    private String errorMessage;
}
