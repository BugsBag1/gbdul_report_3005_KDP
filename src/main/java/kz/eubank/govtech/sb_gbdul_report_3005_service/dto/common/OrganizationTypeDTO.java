package kz.eubank.govtech.sb_gbdul_report_3005_service.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrganizationTypeDTO {
    @Schema(description = "1-юрлицо 2-филиал 3-представительство")
    private Integer orgFormCode;
    @Schema(description = "БИН организации")
    private String bin;
    @Schema(description = "Полное наименование организации на русском языке")
    private String organizationNameRu;
    @Schema(description = "Полное наименование организации на государственном языке")
    private String organizationNameKz;
    @Schema(description = "Орган юстиции, зарегистрировавший организацию")
    private DirectoryTypeDTO registrationDepartment;
    @Schema(description = "Дата первичной регистрации")
    private LocalDate registrationDate;
    @Schema(description = "Дата последней перерегистрации")
    private LocalDate registrationLastDate;
    @Schema(description = "Руководитель организации")
    private PersonLeaderTypeDTO organizationLeader;
    @Schema(description = "Участники, учредители - юрлица")
    private List<OrganizationShortTypeDTO> foundersUL;
    @Schema(description = "Участники, учредители - физлица")
    private List<PersonTypeDTO> foundersFL;
    @Schema(description = "Количество участников, учредителей")
    private int foundersCount;
    @Schema(description = "Виды деятельности на русском языке")
    private String activityTypeNameRu;
    @Schema(description = "Виды деятельности на государственном языке")
    private String activityTypeNameKz;
    @Schema(description = "Сведения о головной организации филиала или представительства")
    private OrganizationShortTypeDTO headerOrganization;
    @Schema(description = "Адрес местонахождения")
    private AddressTypeDTO legalAddress;
    @Schema(description = "Количество учредителей фл")
    private int countFlFounders;
    @Schema(description = "Количество учредителей юл")
    private int countUlFounders;
}

