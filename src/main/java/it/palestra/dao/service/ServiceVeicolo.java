package it.palestra.dao.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.palestra.dao.entity.Veicolo;
import it.palestra.dao.interfaces.JpaVeicolo;
import it.palestra.dao.repository.RepositoryVeicolo;

@Service
public class ServiceVeicolo {
	private static final Logger logger = LoggerFactory.getLogger(ServiceCliente.class);
	
	private RepositoryVeicolo repositoryVeicolo;
	
	@Autowired
	public ServiceVeicolo(RepositoryVeicolo repositoryVeicolo) {
		this.repositoryVeicolo=repositoryVeicolo;
	}

	
	public List<Veicolo> tuttiVeicoli(){
		return repositoryVeicolo.tuttiVeicoli();
	}
	
	
	
	
	
}
