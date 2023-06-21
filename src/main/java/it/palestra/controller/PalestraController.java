package it.palestra.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.palestra.PalestraApplication;
import it.palestra.dao.QueryObj.QueryPersTess;
import it.palestra.dao.entity.Persona;
import it.palestra.dao.repository.RepositoryClienti;
import it.palestra.dao.service.ServiceCliente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
//import jakarta.validation.Valid;



@RestController
@ResponseBody

@RequestMapping("/palestra")
public class PalestraController {
	private static Logger logger = LoggerFactory.getLogger(PalestraController.class); 
	
			//private static final Logger logger = LoggerFactory.getLogger(PalestraApplication.class);		
	
	@Autowired 
	ServiceCliente serviceCliente;
	
//	@Autowired
//	RepositoryClienti repository;

	
	
	// http://localhost:8080/palestra/inserisci	
	@PostMapping("/inserisci")
	public ResponseEntity<Persona> inserimentoCliente(@Valid Persona persona,BindingResult result) {			
		String info;
		HttpStatus status; 
			if(result.hasErrors()) {
				StringBuilder sb = new StringBuilder();
	            
				for (FieldError error : result.getFieldErrors()) {
					sb.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
	            }
				
				info="Errore di inserimento: ".concat(sb.toString());
				status = HttpStatus.BAD_REQUEST;
			}else {
				serviceCliente.insPersona(persona);
				info="Inserimento Avvenuto";
				status = HttpStatus.CREATED;
			}
			
		logger.info(info);		
		return ResponseEntity.status(status).body(persona);		
		
	}
	
//	@PostMapping("/inserisci_01")
//	public String inserimentoCliente_01(@Valid Persona persona) {			
//			repository.inserisciPersona(persona);    
//			return "Inserito--->"+persona.getNome();
//	}
	
	
	
	//Modifica
	// http://localhost:8080/palestra/modifica/
	@GetMapping("/modifica")
	public String modificaPersona() {
		Persona persona = new Persona();
//		persona.setId_persona(4);
//		persona.setNome("Mariagiovanna");
//		persona.setCognome("Picchia");
//		persona.setCitta("Salerno");
//		persona.setTelefonoEmegenza("333345");
//		persona.setTelefonoPersona("888822222");
		
		serviceCliente.insPersona(persona);
		
		
		return null;
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
	
	// http://localhost:8080/palestra/listaCitta?citta='Roma'
	@GetMapping("/listaCitta")
	public List<Persona> elencoCitta(@RequestParam("citta") String citta){
		
		List<Persona> p = new ArrayList<Persona>();
		logger.info("=======Controller==="+citta+"==================");
		p=serviceCliente.listaCitta(citta);
		logger.info("===elementi di ritorno======"+p.size()+"=======");
		
		return p;
	
	
	}
	
	
}





















