package it.palestra.dao.repository;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.palestra.dao.entity.Veicolo;
import it.palestra.dao.interfaces.JpaVeicolo;

@Repository
public class RepositoryVeicolo {
	
	private static final Logger logger = LoggerFactory.getLogger(RepositoryVeicolo.class);
	
	public JpaVeicolo jpaVeicolo;
    
	@Autowired
	public RepositoryVeicolo(JpaVeicolo jpaVeicolo) {
		this.jpaVeicolo=jpaVeicolo;
	}
    
	public List<Veicolo> tuttiVeicoli(){
		
		this.getVeicoloFromId(2);
		this.getVeicoloFromNomeVeicolo("Iveco");
		return jpaVeicolo.findAll();
	
	}
	
	public Optional<Veicolo> getVeicoloFromId(Integer id){
		//jpaVeicolo.findById(id).get().getNomeVeicolo();
		logger.info(jpaVeicolo.findById(id).get().getNomeVeicolo());
		return null;
	}
	
	public Optional<Veicolo> getVeicoloFromNomeVeicolo(String nome){
		logger.info(jpaVeicolo.findByNomeVeicolo(nome).get().getTipoVeicolo());
		
		List<Veicolo> veicolo = jpaVeicolo.getAllNome_VeicoloPerTipo_veicolo("Furgone");
		
				veicolo.forEach(x->{
					System.out.println(x.getNomeVeicolo());
				});			
				
				
				
		return null;
	}
	
	
	
}
