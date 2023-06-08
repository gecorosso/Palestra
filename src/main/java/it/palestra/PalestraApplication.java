package it.palestra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@ComponentScan("it.palestra")

//EnableJdbcRepositories deve puntare alle interfacce che instanziano 
//la jpa repository
@EnableJdbcRepositories(basePackages = "it.palestra.dao.interfaces")

public class PalestraApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PalestraApplication.class, args);
	}
	
}
