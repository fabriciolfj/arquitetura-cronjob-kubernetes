package com.github.fabriciolfj.transacaoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.fabriciolfj.transacaoservice")
@EnableFeignClients
@EnableJpaRepositories(basePackages = {"com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository"} )
@EntityScan(basePackages = {"com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities"})
public class TransacaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacaoServiceApplication.class, args);
	}

}
