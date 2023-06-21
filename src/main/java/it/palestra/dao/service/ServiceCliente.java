package it.palestra.dao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.palestra.dao.QueryObj.QueryPersTess;
import it.palestra.dao.entity.Persona;
import it.palestra.dao.repository.RepositoryClienti;

@Service
public class ServiceCliente {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceCliente.class);
	
	private RepositoryClienti repository_clienti;
	
	@Autowired
	public ServiceCliente(RepositoryClienti repository_clienti) {
		this.repository_clienti=repository_clienti;
	}
	

	//Inserimento-Modifica
	public void insPersona(Persona persona) {
		repository_clienti.inserisciPersona(persona);
	}
    
	
	
//	//Elenco Clienti
//	public List<Persona> listaTuttiClienti(){
//		return repository_clienti.listaClienti();
//	}
	
	//VediQuery
	public List<Object[]> listaQuery(){
		return repository_clienti.queryCompleta();
	}
	
	public List<QueryPersTess> listaQueryConObj(){
		return repository_clienti.queryCompletaConObj();
	}
	
	public List<Persona> listaCitta(String citta){
		logger.info("==Service==="+citta+"==============");
		return repository_clienti.tutteCitta(citta);
	}
	

	
}
