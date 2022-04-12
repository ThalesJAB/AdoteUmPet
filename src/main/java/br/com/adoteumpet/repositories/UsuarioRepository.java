package br.com.adoteumpet.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adoteumpet.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	@Query("from Usuario where status = true")
	public List<Usuario> findAll();
	
	/*
	@Query("from Usuario where status = true")
	public Optional<Usuario> findById(Long id);
*/
}
