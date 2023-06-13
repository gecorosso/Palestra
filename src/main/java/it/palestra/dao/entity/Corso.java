package it.palestra.dao.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity(name = "Corso")
public class Corso implements Serializable {
    private static final long serialVersionUID = -4280003518535742057L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer	Id_corso;
    
    @Column(name = "sala_corso")
	String sala_corso;
    
    @Column(name = "orario_corso")
    String orario_corso;

	@ManyToMany(mappedBy = "corso")
	List<Persona> persona;
	
    
	
	
	public Corso(Integer id_corso, String sala_corso, String orario_corso) {
		Id_corso = id_corso;
		this.sala_corso = sala_corso;
		this.orario_corso = orario_corso;
	}

	public Corso() {
		
	}
	
	public Integer getId_corso() {
		return Id_corso;
	}

	public void setId_corso(Integer id_corso) {
		Id_corso = id_corso;
	}

	public String getSala_corso() {
		return sala_corso;
	}

	public void setSala_corso(String sala_corso) {
		this.sala_corso = sala_corso;
	}
	
	public String getOrario_corso() {
		return orario_corso;
	}
	
	public void setOrario_corso(String orario_corso) {
		this.orario_corso = orario_corso;
	}
}
