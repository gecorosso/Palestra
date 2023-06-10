package it.palestra.dao.QueryObj;

import org.springframework.stereotype.Component;

@Component
public class QueryPersTess {
	//Trattasi di un oggetto che viene utilizzata come contenitore
	//della seguente query
	//SELECT  p.cognome,p.nome,p.citta, t.codice_tessera,t.status_tessera FROM persona p , tessera t WHERE p.id_persona=t.id_persona

	//Persona	
	//private Integer id_persona;
	private String nome;	
	private String cognome;	
	private String citta;	
	
	//Tessera
	//private Integer id_tessera;
	private String codice_tessera;
	private String status_tessera;

	
	public QueryPersTess() {
	}
	
	public String getNome() {
		return nome;
	}
//	public Integer getId_persona() {
//		return id_persona;
//	}
//
//	public Integer getId_tessera() {
//		return id_tessera;
//	}

//	public void setId_persona(Integer id_persona) {
//		this.id_persona = id_persona;
//	}
//
//	public void setId_tessera(Integer id_tessera) {
//		this.id_tessera = id_tessera;
//	}

	public String getCognome() {
		return cognome;
	}

	public String getCitta() {
		return citta;
	}


	public String getCodice_tessera() {
		return codice_tessera;
	}

	public String getStatus_tessera() {
		return status_tessera;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setCodice_tessera(String codice_tessera) {
		this.codice_tessera = codice_tessera;
	}

	public void setStatus_tessera(String status_tessera) {
		this.status_tessera = status_tessera;
	}

}
