package it.palestra.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Persona;

@Repository
//public interface JpaPersona extends CrudRepository<Persona, Integer>{
public interface JpaPersona extends JpaRepositoryImplementation<Persona, Integer>{
//public interface JpaPersona extends JpaRepository<Persona, Integer>{
  
    public List<Persona> findByCognome(String cognome);
    
    @Query(value="SELECT p.cognome,p.nome,p.citta, t.codice_tessera,t.status_tessera FROM persona p , tessera t  WHERE p.id_persona=t.Id_tessera",nativeQuery=true)
    List<Object[]> findByCognomeAndNomeAndCittaAndCodiceTesseraAndStatusTessera();

    
//    @Query(value = "SELECT  * FROM `Persona` WHERE persona.citta=:citta", nativeQuery = true)
//    List<Persona>getAllPersonasPerCitta(@Param("citta") String citta);
//  
   
   // public List<Persona> findByCitta(String citta);
    
    
   // @Query(value="SELECT citta FROM persona  WHERE persona.citta=:citta",nativeQuery=true)
   // public List<Persona> findByCitta(String citta);
    
   
    
     public void deleteByNome(String nome);
}	
