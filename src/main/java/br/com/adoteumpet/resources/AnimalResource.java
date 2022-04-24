package br.com.adoteumpet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.adoteumpet.entities.Animal;
import br.com.adoteumpet.services.AnimalService;

@RestController
@RequestMapping("/animais")
public class AnimalResource {

	@Autowired
	private AnimalService service;

	@GetMapping
	public ResponseEntity<List<Animal>> findAll() {
		List<Animal> animais = service.findAll();

		return ResponseEntity.ok().body(animais);
	}

	@GetMapping(value = "/ong/{id_ong}")
	public ResponseEntity<List<Animal>> findAllByONG(@PathVariable Integer id_ong){
		List<Animal> animaisOng = service.findAllByONG(id_ong);
		
		return ResponseEntity.ok().body(animaisOng);
	}
	
	

}
