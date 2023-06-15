package it.palestra.dao.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Tessera")
@AllArgsConstructor
@NoArgsConstructor
public class Tessera implements Serializable {
	private static final long serialVersionUID = -6147937015471291751L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	Integer Id_tessera;

	@Column(name = "codice_tessera")
	@Getter @Setter
	String codice_tessera;

	@Column(name = "status_tessera")
	@Getter @Setter
	String status_tessera;

//	//==Relazioni==
//	@OneToOne
//	@JoinColumn(name="id_persona")
//	private Persona persona;

//Relazione: Persona-Tessera
//Rapporto 1:1
	@OneToOne
	@JoinColumn(name = "id_persona")
	Persona persona;	

}
