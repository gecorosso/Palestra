package it.palestra.dao.interfaces;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Persona;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPersona extends JpaRepositoryImplementation<Persona, Integer>{
    public List<Persona> findByNome(String nome);
    public List<Persona> findByCognome(String cognome);
}	
