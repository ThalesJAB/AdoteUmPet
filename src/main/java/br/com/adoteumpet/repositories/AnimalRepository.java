package br.com.adoteumpet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adoteumpet.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

//	@Query("from Animal WHERE Ong_id = ?1")
//	public List<Animal> findAllByONG(Integer idOng);
	
	@Query("Select obj from Animal obj WHERE Ong_id = ?1")
	public List<Animal> findAllByONG(Long idOng);


}
