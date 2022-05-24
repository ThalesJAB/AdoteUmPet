package br.com.adoteumpet.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.adoteumpet.entities.Animal;
import br.com.adoteumpet.services.AnimalService;

@CrossOrigin("*")
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
	public ResponseEntity<List<Animal>> findAllByONG(@PathVariable Long id_ong){
		List<Animal> animaisOng = service.findAllByONG(id_ong);
		
		return ResponseEntity.ok().body(animaisOng);
	}
	
	@PostMapping
	public ResponseEntity<Animal> create(@RequestParam(value="ong", defaultValue="0") Long id_ong, @RequestBody Animal obj){
	
		Animal animal = service.create(id_ong, obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/animais/ong/{id_ong}/{id}").buildAndExpand(id_ong, animal.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal obj){
		Animal animal = service.update(id, obj);
		
		return ResponseEntity.ok().body(animal);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
