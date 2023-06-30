package it.palestra.dao.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Veicolo;


@Repository
public interface JpaVeicolo extends JpaRepository<Veicolo, Integer> {
    
	
	 Optional<Veicolo> findById(Integer id);
	 Optional<Veicolo> findByNomeVeicolo(String nomeVeicolo);
	 
	 @Query(value="SELECT * FROM veicolo WHERE tipo_veicolo =:tipo_veicolo", nativeQuery=true)
	 List<Veicolo> getAllNome_VeicoloPerTipo_veicolo(@Param("tipo_veicolo") String tipo_veicolo);
	 
	
}
