package it.palestra.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Persona;
import it.palestra.dao.interfaces.JpaPersona;

@Repository
public class RepositoryClienti {
	private JpaPersona jpa_persona;

	@Autowired
	public RepositoryClienti(JpaPersona jpa_persona) {
		this.jpa_persona = jpa_persona;
	}
	
		
    public List<Persona> cercaClienteConNome(String nome){
    	return jpa_persona.findByNome(nome);
    }

    public Optional<Persona> cercaClienteConId(Integer id) {
    	return jpa_persona.findById(id);
    }
    
    //tuttal la lista clienti
    public List<Persona> listaClienti(){
    	return jpa_persona.findAll();
    }
    
    //Lista di tutti i clienti
    public List<Persona> elencoClienti(){
    	return jpa_persona.findAll();
    }
    
    //Inserimento-Modifica
    public void inserisciPersona(Persona persona) {
    	jpa_persona.save(persona);
    }
   
    //Cancellazione
    public void cancellaPersona(Integer id) {
    	jpa_persona.deleteById(id);
    }
    
    
    
    
}
