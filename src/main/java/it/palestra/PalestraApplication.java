package it.palestra;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@ComponentScan("it.palestra")
//EnableJdbcRepositories deve puntare alle interfacce che instanziano 
//la jpa repository
@EnableJdbcRepositories(basePackages = "it.palestra.dao.interfaces")

public class PalestraApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(PalestraApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(PalestraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// Con questo metodo si apre prima di tutti gli altri!!
		// utile per eseguire le configurazioni del progetto.
		logger.info("Applicativo Avviato correttamente!!!");
		
	}
	
}
