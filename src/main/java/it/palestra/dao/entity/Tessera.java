package it.palestra.dao.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "Tessera")
public class Tessera implements Serializable {
	private static final long serialVersionUID = -6147937015471291751L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id_tessera;

	@Column(name = "codice_tessera")
	String codice_tessera;

	@Column(name = "status_tessera")
	String status_tessera;

	@OneToOne
	@JoinColumn(name="id_persona")
	private Persona persona;
	
	
	public Tessera() {
	}

	public Tessera(Integer id_tessera, String codice_tessera, String status_tessera) {
		this.Id_tessera = id_tessera;
		this.codice_tessera = codice_tessera;
		this.status_tessera = status_tessera;
	}

	public Integer getId_tessera() {
		return Id_tessera;
	}

	public void setId_tessera(Integer id_tessera) {
		Id_tessera = id_tessera;
	}

	public String getCodice_tessera() {
		return codice_tessera;
	}

	public void setCodice_tessera(String codice_tessera) {
		this.codice_tessera = codice_tessera;
	}

	public String getStatus_tessera() {
		return status_tessera;
	}

	public void setStatus_tessera(String status_tessera) {
		this.status_tessera = status_tessera;
	}

}
