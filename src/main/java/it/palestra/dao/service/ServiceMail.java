package it.palestra.dao.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.palestra.dao.entity.Persona;
import lombok.extern.java.Log;

@Component
@Log
public class ServiceMail {

	
	public void inviaEmail(Persona persona) {
		log.info("Evento eseguito PROCEDURA INVIO EMAIL NUMERO UNO "+persona.nome+"-> "+persona.cognome+"-> "+persona.citta);
	}
	
	
	public void inviaEmailAzienda(Persona persona) {
		log.info("Evento eseguito PROCEDURA INVIO EMAIL NUMERO DUE "+persona.nome+"-> "+persona.cognome+"-> "+persona.citta);
	}
	

}
