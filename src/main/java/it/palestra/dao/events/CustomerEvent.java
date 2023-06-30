package it.palestra.dao.events;

import org.springframework.stereotype.Component;

import it.palestra.dao.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerEvent {
	private Persona persona;
}
