package br.capiroto.names;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.capiroto" })
public class CapirotoNamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapirotoNamesApplication.class, args);
	}
}
