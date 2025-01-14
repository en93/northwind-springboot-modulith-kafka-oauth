package en93.sample.northwindmodulith.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "en93.sample.northwindmodulith")
public class NorthwindModulithApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindModulithApplication.class, args);
	}

}
