package kz.eubank.govtech.sb_gbdul_report_3005_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = {"kz.govtech.m11s", "kz.eubank.govtech.sb_gbdul_report_3005_service"}
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
