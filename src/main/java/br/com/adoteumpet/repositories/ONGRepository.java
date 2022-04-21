package br.com.adoteumpet.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adoteumpet.entities.ONG;
import br.com.adoteumpet.entities.Usuario;

@Repository
public interface ONGRepository extends JpaRepository<ONG, Long>{
	
	
	@Query("from ONG where status = true")
	public List<ONG> findAll();
	
	//@Query("from ONG where status = true")
	public Optional<ONG> findById(Long id);

	@Query("SELECT o from ONG o WHERE o.login = ?1 and o.senha = ?2 and o.status = true")
	public ONG login(String login, String senha);

}
