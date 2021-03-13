package br.com.rodrigo.cdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdcApplication.class, args);
	}

}
