package it.palestra.dao.listner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import it.palestra.dao.events.CustomerEvent;
import it.palestra.dao.service.ServiceMail;
import lombok.extern.java.Log;


@Log
@Component
public class EmailListner {	
	@Autowired 
	ServiceMail mail;
	
	//Quando Inserisce Manda il messaggio
	@EventListener
	public void sendMessageAfterSave(CustomerEvent evento) {
		mail.inviaEmail(evento.getPersona());
		log.info("Evento Intercettato!!!");
	}

}
