package it.palestra.dao.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Veicolo")
@AllArgsConstructor
@NoArgsConstructor
public class Veicolo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVeicolo;
    
	@Getter @Setter
	private String nomeVeicolo;
	
	@Getter @Setter
	private String tipoVeicolo;

}
