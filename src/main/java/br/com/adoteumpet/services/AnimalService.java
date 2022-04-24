package br.com.adoteumpet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adoteumpet.entities.Animal;
import br.com.adoteumpet.repositories.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repository;

	public List<Animal> findAll() {
	
		return repository.findAll();
	}

	public List<Animal> findAllByONG(Integer idOng) {
		return repository.findAllByONG(idOng);
	}
	

}
