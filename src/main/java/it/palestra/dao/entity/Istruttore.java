package it.palestra.dao.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Istruttore")
@AllArgsConstructor
@NoArgsConstructor
public class Istruttore implements Serializable {
		
	private static final long serialVersionUID = -7311726594072157950L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	Integer	id_istruttore;
	
	@Column(name="nome")
	@Getter @Setter
	String nome;
	
	@Column(name="cognome")
	@Getter @Setter
	String cognome;
	
	@Column(name="disciplina")
	@Getter @Setter
	String disciplina;
			
//	//Istruttore-Persona 
//	//un istruttore molte persone
//	@OneToMany(mappedBy = "istruttore")
//	List<Persona> persona;
	
//Relazione: Istruttore-Persona
//tipo di rapporto Uno a molti	

	@OneToMany(mappedBy = "istruttore")
	List<Persona> persona;
	

}
