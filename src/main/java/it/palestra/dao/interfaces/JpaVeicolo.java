package it.palestra.dao.interfaces;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import it.palestra.dao.entity.Veicolo;

public interface JpaVeicolo extends JpaRepositoryImplementation<Veicolo, Integer> {
 
	
}
