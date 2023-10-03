package br.com.api.cep.viacepapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ViacepApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViacepApiApplication.class, args);
	}

}
