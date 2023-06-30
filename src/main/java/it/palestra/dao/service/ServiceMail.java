package it.palestra.dao.service;

import org.springframework.stereotype.Component;

import it.palestra.dao.entity.Persona;
import lombok.extern.java.Log;

@Component
@Log
public class ServiceMail {

	public void inviaEmail(Persona persona) {
		log.info("Evento eseguito PROCEDURA INVIO EMAIL NUMERO UNO "+persona.nome+"-> "+persona.cognome+"-> "+persona.citta);
		
	}
	

}
