package it.palestra.dao.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = -7784570466641503356L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_persona;

	@Column(name = "nome")
	String nome;

	@Column(name = "cognome")
	String cognome;

	@Column(name = "citta")
	String citta;

	@Column(name = "telefonoPersona")
	String telefonoPersona;

	@Column(name = "telefonoEmegenza")
	String telefonoEmegenza;

	public Persona() {	
		
	}

	public Persona(int id_persona, String nome, String cognome, String citta, String telefonoPersona,
			String telefonoEmegenza) {
		this.id_persona = id_persona;
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.telefonoPersona = telefonoPersona;
		this.telefonoEmegenza = telefonoEmegenza;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getTelefonoPersona() {
		return telefonoPersona;
	}

	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}

	public String getTelefonoEmegenza() {
		return telefonoEmegenza;
	}

	public void setTelefonoEmegenza(String telefonoEmegenza) {
		this.telefonoEmegenza = telefonoEmegenza;
	}

}
