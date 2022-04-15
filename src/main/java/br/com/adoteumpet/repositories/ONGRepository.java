package br.com.adoteumpet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adoteumpet.entities.ONG;

@Repository
public interface ONGRepository extends JpaRepository<ONG, Long>{
	
	
	@Query("from ONG where status = true")
	public List<ONG> findAll();

}
