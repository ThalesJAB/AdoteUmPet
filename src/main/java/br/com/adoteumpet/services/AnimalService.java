package br.com.adoteumpet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adoteumpet.entities.Animal;
import br.com.adoteumpet.entities.ONG;
import br.com.adoteumpet.repositories.AnimalRepository;
import br.com.adoteumpet.services.exceptions.ObjectNotFoundException;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repository;
	
	@Autowired
	private ONGService ongService;

	public List<Animal> findAll() {
	
		return repository.findAll();
	}
	
	public Animal findById(Long id) {
		Optional<Animal> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Animal não encontrado"));
	}

	public List<Animal> findAllByONG(Long idOng) {
		return repository.findAllByONG(idOng);
	}

	public Animal create(Long id_ong, Animal obj) {
		obj.setId(null);
		ONG ong = ongService.findById(id_ong);
		
		obj.setOng(ong);
		
		return repository.save(obj);
	}

	public Animal update(Long id, Animal obj) {
		Animal animal = findById(id);
		
		animal.setNome(obj.getNome());
		animal.setAdotado(obj.getAdotado());
		animal.setDescricao(obj.getDescricao());
		animal.setIdade(obj.getIdade());
		animal.setImagem(obj.getImagem());
		animal.setObservacoes(obj.getObservacoes());
		animal.setPeso(obj.getPeso());
		animal.setRaca(obj.getRaca());
		
		return repository.save(animal);
		
	}

	public void delete(Long id) {
		Animal animal = findById(id);
		animal.setStatus(false);
		repository.save(animal);
		
		
	}

	

	
	

}
