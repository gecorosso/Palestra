package it.palestra.dao.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity(name = "Persona")
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
	private static final long serialVersionUID = -7784570466641503356L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	@Getter @Setter
	Integer id_persona;

	@Column(name = "nome")
	@NotNull
	@NotEmpty
	@NotBlank
	@Getter @Setter
	String nome;

	@Column(name = "cognome")
	@NotNull
	@NotEmpty
	@NotBlank
	@Getter @Setter
	String cognome;

	@Column(name = "citta")
	@NotNull
	@NotEmpty
	@NotBlank
	@Getter @Setter
	String citta;

	@Column(name = "telefonoPersona")
	@NotNull
	@NotEmpty
	@NotBlank
	@Getter @Setter
	String telefonoPersona;

	@Column(name = "telefonoEmegenza")
	@NotNull
	@NotEmpty
	@NotBlank
	@Getter @Setter
	String telefonoEmegenza;

//	//==Relazioni==
//	//Persona-Tessera 1 ad uno 
//	@OneToOne(mappedBy = "persona", cascade=CascadeType.ALL)
//	private Tessera tessera;
//	
//	//Persona-Istruttore molti a 1
//	@ManyToOne
//	@JoinColumn(name = "id_istruttore")
//	Istruttore istruttore;
//
//	//Persona-Corso
//	//Molte persone partecipano a molti corsi
//	@ManyToMany()
//	@JoinTable(
//		name="persona-corso",
//		joinColumns=@JoinColumn(name="id_persona"),
//		inverseJoinColumns=@JoinColumn(name="Id_corso")
//	)
//	private List<Corso> corso;

//===ESERCIZIO=Relazioni======

//Relazione Persona-Tessera rapporto 1:1
	@OneToOne(mappedBy = "persona")
	Tessera tessera;

//Relazione Istruttore-Persona rapporto 1:molti
	@ManyToOne
	@JoinColumn(name = "id_istruttore")
	private Istruttore istruttore;

//=============== Relazione Molti a molti

	@ManyToMany
	@JoinTable(name = "corso-persona", joinColumns = @JoinColumn(name = "Id_corso"), inverseJoinColumns = @JoinColumn(name = "id_persona"))
	private List<Corso> corso;

}
