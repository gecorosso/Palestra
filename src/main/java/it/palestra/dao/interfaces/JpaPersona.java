package it.palestra.dao.interfaces;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Persona;
import it.palestra.dao.entity.Veicolo;

@Repository
//public interface JpaPersona extends CrudRepository<Persona, Integer>{
public interface JpaPersona extends JpaRepositoryImplementation<Persona, Integer>{
//public interface JpaPersona extends JpaRepository<Persona, Integer>{
  
    public List<Persona> findByCognome(String cognome);
    
    @Query(value="SELECT p.cognome,p.nome,p.citta, t.codice_tessera,t.status_tessera FROM persona p , tessera t  WHERE p.id_persona=t.Id_tessera",nativeQuery=true)
    List<Object[]> findByCognomeAndNomeAndCittaAndCodiceTesseraAndStatusTessera();

    
    @Query(value = "SELECT  * FROM Persona WHERE persona.citta=:xx", nativeQuery = true)
    public List<Persona>findCittaByCitta(@Param("xx") String xx);
    
    public List<Persona> findByCitta(String citta);
    
    
     
//    @Query(value = "SELECT  * FROM Persona WHERE persona.citta=:citta", nativeQuery = true)
//    public List<Persona> findCittaByCitta(@Param("citta") String citta);
//    
    
      
    
    
    //==Funziona
    @Query(value = "SELECT * FROM Persona WHERE persona.id_persona=:id", nativeQuery = true)
    public List<Persona> findCittaByIdPersonas(@Param("id") Integer id);
    
    
    
   // @Query(value="SELECT citta FROM persona  WHERE persona.citta=:citta",nativeQuery=true)
   // public List<Persona> findByCitta(String citta);
    
   
    
     public void deleteByNome(String nome);
}	
