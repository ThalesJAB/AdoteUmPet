package br.com.adoteumpet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adoteumpet.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
