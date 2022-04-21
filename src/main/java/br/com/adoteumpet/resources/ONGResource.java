package br.com.adoteumpet.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.adoteumpet.entities.ONG;
import br.com.adoteumpet.entities.Usuario;
import br.com.adoteumpet.services.ONGService;

@RestController
@RequestMapping("/ongs")
public class ONGResource {
	
	@Autowired
	private ONGService service;
	
	@GetMapping
	public ResponseEntity<List<ONG>> findAll(){

		List<ONG> ongs = service.findAll();
		
		return ResponseEntity.ok().body(ongs);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ONG> findById(@PathVariable Long id){
		ONG ong = service.findById(id);
		return ResponseEntity.ok().body(ong);
	}
	
	@PostMapping
	public ResponseEntity<ONG> create(@RequestBody ONG obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ONG> update(@PathVariable Long id, @RequestBody ONG obj){
		ONG ong = service.update(id, obj);
		return ResponseEntity.ok().body(ong);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<ONG> login(@RequestBody ONG obj) {
		ONG ong = service.login(obj);

		return ResponseEntity.ok().body(ong);

	}
	
	
	
	

}
