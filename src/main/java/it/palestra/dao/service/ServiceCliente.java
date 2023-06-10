package it.palestra.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.palestra.dao.QueryObj.QueryPersTess;
import it.palestra.dao.entity.Persona;
import it.palestra.dao.repository.RepositoryClienti;

@Service
public class ServiceCliente {
	
	private RepositoryClienti repository_clienti;
	
	@Autowired
	public ServiceCliente(RepositoryClienti repository_clienti) {
		this.repository_clienti=repository_clienti;
	}
	

	//Inserimento-Modifica
	public void insPersona(Persona persona) {
		repository_clienti.inserisciPersona(persona);
	}
    
	
	
	//Elenco Clienti
	public List<Persona> listaTuttiClienti(){
		return repository_clienti.listaClienti();
	}
	
	//VediQuery
	public List<Object[]> listaQuery(){
		return repository_clienti.queryCompleta();
	}
	
	public List<QueryPersTess> listaQueryConObj(){
		return repository_clienti.queryCompletaConObj();
	}
	
	
	
	
}
