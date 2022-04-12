package br.com.adoteumpet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adoteumpet.entities.ONG;

@Repository
public interface ONGRepository extends JpaRepository<Long, ONG>{

}
