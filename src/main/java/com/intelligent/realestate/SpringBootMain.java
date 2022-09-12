package com.intelligent.realestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Inicia Spring Boot. La class SpringBootMain tiene que estar en el paquete
 * {@code com.intelligent.realestate}, de otra manera no va a scanear las
 * classes que no se encuentren debajo del paquete
 * {@code com.intelligent.realestate}.
 */
@SpringBootApplication(scanBasePackages = {"com.intelligent.realestate"})
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBootMain {

	public static void main(String[] args) {
		System.out.println("Initializando Spring-Boot");
		SpringApplication.run(SpringBootMain.class, args);
	}
}
