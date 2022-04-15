package br.com.adoteumpet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adoteumpet.entities.ONG;
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
	
	

}
