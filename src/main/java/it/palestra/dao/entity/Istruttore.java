package it.palestra.dao.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "Istruttore")
public class Istruttore implements Serializable {
		
	private static final long serialVersionUID = -7311726594072157950L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer	id_istruttore;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="cognome")
	String cognome;
	
	@Column(name="disciplina")
	String disciplina;
			
	//Istruttore-Persona 
	//un istruttore molte persone
	@OneToMany(mappedBy = "istruttore")
	List<Persona> persona;
	
	public Istruttore() {
	}
	
	public Istruttore(Integer id_istruttore, String nome, String cognome, String disciplina) {
		this.id_istruttore = id_istruttore;
		this.nome = nome;
		this.cognome = cognome;
		this.disciplina = disciplina;
	}

	public Integer getId_istruttore() {
		return id_istruttore;
	}

	public void setId_istruttore(Integer id_istruttore) {
		this.id_istruttore = id_istruttore;
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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}	

}
