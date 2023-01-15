package com.intelligent.realestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inicia Spring Boot. La class SpringBootMain tiene que estar en el paquete
 * {@code com.intelligent.realestate}, de otra manera no va a scanear las
 * classes que no se encuentren debajo del paquete
 * {@code com.intelligent.realestate}.
 *
 * Cuando hay varias classes con el {@code main} metodo, es necesario configurar
 * la clase a usar en el pom.xml.
 */
@SpringBootApplication(scanBasePackages = {"com.intelligent.realestate"})
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBootMain {

	public static void main(String[] args) {
		System.out.println("Initializando Spring-Boot");
		//System.out.println("---- Inicializando Main SpringBootMain ----");
		SpringApplication.run(SpringBootMain.class, args);
	}
} 