package br.com.adoteumpet.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adoteumpet.dtos.UsuarioDTO;
import br.com.adoteumpet.entities.ONG;
import br.com.adoteumpet.entities.Usuario;
import br.com.adoteumpet.repositories.ONGRepository;
import br.com.adoteumpet.services.exceptions.ObjectNotFoundException;

@Service
public class ONGService {
	
	@Autowired
	private ONGRepository repository;
	
	@Autowired
	private SendEmailService sendEmailService;
   
	public List<ONG> findAll() {
		return repository.findAll();
	}

	public ONG findById(Long id) {
		
		Optional<ONG> obj = repository.findById(id);
		//List<UsuarioDTO> usuariosFiliados = convertUsuarioDTO(obj.get());
	
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("ONG não encontrada"));
		
	}

	public ONG create(ONG obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public ONG update(Long id, ONG obj) {
		ONG ong = findById(id);
		ong.setBiografia(obj.getBiografia());
		ong.setEmail(obj.getEmail());
		ong.setSenha(obj.getSenha());
		ong.setLogin(obj.getLogin());
		ong.setImagem(obj.getImagem());
		ong.setNomeFantasia(obj.getNomeFantasia());
		ong.setEndereco(obj.getEndereco());
		ong.setTelefone(obj.getTelefone());
		ong.setRazaoSocial(obj.getRazaoSocial());
		
		return repository.save(ong);
		
	}

	public void delete(Long id) {
		ONG ong = findById(id);
		ong.setStatus(false);
		repository.save(ong);
		
	}

	public ONG login(ONG obj) {
		ONG ong = repository.login(obj.getLogin(), obj.getSenha());
		System.out.println(obj.getLogin() + " - " + obj.getSenha());
		
		
		return ong;
	}
	
	
	
	/*
	
	private List<UsuarioDTO> convertUsuarioDTO(ONG ong){
		List<UsuarioDTO> usuariosDTO = ong.getUsuariosColaboradores().stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return usuariosDTO;
	}
	*/
	
	
	
	

}
