package it.palestra.dao.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Corso")
@AllArgsConstructor
@NoArgsConstructor
public class Corso implements Serializable {
	private static final long serialVersionUID = -4280003518535742057L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	Integer Id_corso;

	@Column(name = "sala_corso")
	@Getter @Setter
	String sala_corso;

	@Column(name = "orario_corso")
	@Getter @Setter
	String orario_corso;

//	//==Relazioni==
//  @ManyToMany(mappedBy = "corso")
//	List<Persona> persona;
//==========================
//Relazione: Corso - Persona rapporto Molti a molti

	@ManyToMany(mappedBy = "corso")
	List<Persona> persona;

	
}
