package it.palestra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.palestra.dao.entity.Persona;
import it.palestra.dao.service.ServiceCliente;

@Controller
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
	
	//Cancellazione
	// http://localhost:8080/palestra/cancella?id=1
	@DeleteMapping("/cancella")
	public String cancella(@RequestParam("id") Integer id) {
		serviceCliente.cancPersona(id);
		return "Cancellazione eseguita"+id.toString();
	}
	
	
	
	
	
}





















