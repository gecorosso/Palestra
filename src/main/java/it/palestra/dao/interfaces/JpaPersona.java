package it.palestra.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Persona;

@Repository
public interface JpaPersona extends JpaRepositoryImplementation<Persona, Integer>{
  
    public List<Persona> findByCognome(String cognome);
    
    @Query(value="SELECT p.cognome,p.nome,p.citta, t.codice_tessera,t.status_tessera FROM persona p , tessera t  WHERE p.id_persona=t.Id_tessera",nativeQuery=true)
    List<Object[]> findByCognomeAndNomeAndCittaAndCodiceTesseraAndStatusTessera();

    
    
    public void deleteByNome(String nome);

}	
