package br.com.adoteumpet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adoteumpet.email.EmailMessagesUsuario;
import br.com.adoteumpet.entities.Usuario;
import br.com.adoteumpet.repositories.UsuarioRepository;
import br.com.adoteumpet.services.exceptions.ObjectNotFoundException;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private SendEmailService sendEmailService;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}

	public Usuario create(Usuario obj) {
		obj.setId(null); 
		
		Usuario usuarioNovo = repository.save(obj);
		
		this.sendEmailService.send(usuarioNovo.getEmail(), EmailMessagesUsuario.createTitle(usuarioNovo), EmailMessagesUsuario.messageToNewUser(usuarioNovo));
		return usuarioNovo;
	}
	

	public Usuario update(Long id, Usuario obj) {
		Usuario usuario = findById(id);
		
		usuario.setEmail(obj.getEmail());
		usuario.setNome(obj.getNome());
		usuario.setLogin(obj.getLogin());
		usuario.setSenha(obj.getSenha());
		usuario.setTelefone(obj.getTelefone());
		usuario.setEndereco(obj.getEndereco());
		
		return repository.save(usuario);
	}
	
	public void delete(Long id) {
		Usuario usuario = findById(id);
		usuario.setStatus(false);
		repository.save(usuario);
	}

	public Usuario login(Usuario obj) {
		
		Usuario usuario = repository.login(obj.getLogin(), obj.getSenha());
		System.out.println(obj.getLogin() + " - " + obj.getSenha());
		
		
		return usuario;
		
	}
	


}
