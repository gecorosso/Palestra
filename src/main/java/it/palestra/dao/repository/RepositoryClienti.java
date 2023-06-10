package it.palestra.dao.repository;

import java.util.*;
import java.util.Optional;

import org.hibernate.query.spi.QueryParameterBindingTypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Persona;
import it.palestra.dao.interfaces.JpaPersona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import it.palestra.dao.QueryObj.*;

@Repository
public class RepositoryClienti {
	
	
	private JpaPersona jpa_persona;

	@Autowired
	public RepositoryClienti(JpaPersona jpa_persona) {
		this.jpa_persona = jpa_persona;
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
    
    //VediQuery
    public List<Object[]> queryCompleta(){
    	return jpa_persona.findByCognomeAndNomeAndCittaAndCodiceTesseraAndStatusTessera();
    
    }

    
    //Con Obj
    public List<QueryPersTess> queryCompletaConObj(){
    	List<Object[]> lista = jpa_persona.findByCognomeAndNomeAndCittaAndCodiceTesseraAndStatusTessera();
        
    	List<QueryPersTess>lista_di_righe = new ArrayList<>();
    	
    	lista.forEach(myLista -> {
    		QueryPersTess qpt = new QueryPersTess();
    		
    		qpt.setCognome(myLista[0].toString());
    		qpt.setNome(myLista[1].toString());
    		qpt.setCitta(myLista[2].toString());
    		qpt.setCodice_tessera(myLista[3].toString());
    		qpt.setStatus_tessera(myLista[4].toString());
    		
    		lista_di_righe.add(qpt);
    	});
    	    	    	
    	return lista_di_righe;
    }
    
    //cancella
    public void  cancellaPersonaByName(String nome) {
    	jpa_persona.deleteByNome(nome);
    }
    	

    
}
