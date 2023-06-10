package it.palestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.palestra.dao.QueryObj.QueryPersTess;
import it.palestra.dao.entity.Persona;
import it.palestra.dao.service.ServiceCliente;

@RestController
@ResponseBody

@RequestMapping("/palestra")
public class PalestraController {

	@Autowired 
	ServiceCliente serviceCliente;

	
	// http://localhost:8080/palestra/inserisci	
	@GetMapping("/inserisci")
	public String inserimentoCliente() {
		Persona persona = new Persona();
		
		persona.setNome("Mary");
		persona.setCognome("Salterno");
		persona.setCitta("Roma");
		persona.setTelefonoEmegenza("345");
		persona.setTelefonoPersona("22222");
		
		serviceCliente.insPersona(persona);
			
		List<Persona> pp = serviceCliente.listaTuttiClienti();
		
		pp.forEach(listaClienti ->{
			System.out.println(listaClienti.getNome());
		});
		
		return "inserimentoAvvenuto";
	}
	
	//Modifica
	// http://localhost:8080/palestra/modifica/
	@GetMapping("/modifica")
	public String modificaPersona() {
		Persona persona = new Persona();
		persona.setId_persona(4);
		persona.setNome("Mariagiovanna");
		persona.setCognome("Picchia");
		persona.setCitta("Salerno");
		persona.setTelefonoEmegenza("333345");
		persona.setTelefonoPersona("888822222");
		
		serviceCliente.insPersona(persona);
		
		return persona.getNome() + "-->Modificato";
	}
	
	// http://localhost:8080/palestra/modificaPost/
	@PostMapping("/modificaPost")
	public ResponseEntity<Persona> modificaPost(@RequestBody Persona persona){
		serviceCliente.insPersona(persona);
		return ResponseEntity.status(HttpStatus.CREATED).body(persona);
	} 
	
	//Cancellazione
	// http://localhost:8080/palestra/cancella?nome=Teresa
	@GetMapping("/cancella")
	public String cancella(@RequestParam("nome") String nome) {
		return null;
	}
	
	
	// http://localhost:8080/palestra/vediQuery
	@GetMapping("/vediQuery")
	public ResponseEntity<List<QueryPersTess>> vediQuery(){
		
//		List<Object[]> lista = serviceCliente.listaQuery();
//	
//		lista.forEach(xx ->{
//			System.out.print(xx[0].toString());
//			System.out.print(xx[1].toString());
//			System.out.print(xx[2].toString());
//			System.out.print(xx[3].toString());
//			System.out.println(xx[4].toString());
//		} );
//----------------------------------------------
		List<QueryPersTess> listaQuery = serviceCliente.listaQueryConObj();
		
		listaQuery.forEach(myLqe ->{
			System.out.println(myLqe.getCognome());
			System.out.println(myLqe.getNome());
			System.out.println(myLqe.getCitta());
			System.out.println(myLqe.getCodice_tessera());
			System.out.println(myLqe.getStatus_tessera());
			System.out.println("-----------------------------------");
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(listaQuery);
		
	}
	
	
}





















