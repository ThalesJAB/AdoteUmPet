package br.com.adoteumpet.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.adoteumpet.dtos.UsuarioDTO;
import br.com.adoteumpet.entities.Usuario;
import br.com.adoteumpet.services.FotoService;
import br.com.adoteumpet.services.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private FotoService fotoService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> usuarios = service.findAll();
		List<UsuarioDTO> listDTO = usuarios.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);

	}

	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario obj) {
		Usuario usuario = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(usuario);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) {
		Usuario usuario = service.update(id, obj);

		return ResponseEntity.ok().body(usuario);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PostMapping(value = "/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario obj) {
		Usuario usuario = service.login(obj);

		return ResponseEntity.ok().body(usuario);

	}
	
	@PostMapping(value= "/{id}/upload-foto")
	public ResponseEntity<Usuario> upload(@PathVariable Long id, @RequestParam("file") MultipartFile file){
		String nomeFoto = fotoService.salvar(file);
		Usuario usuario = service.findById(id);
		usuario.setImagem(nomeFoto);
		service.update(id, usuario);
		return ResponseEntity.ok().body(usuario);
	}
	
	@DeleteMapping(value = "/{id}/deletar-foto")
	public ResponseEntity<Void> deleteFoto(@PathVariable Long id){
		Usuario usuario = service.findById(id);
		fotoService.excluir(usuario.getImagem());
		usuario.setImagem(null);
		service.update(id, usuario);
		return ResponseEntity.noContent().build();
	};


}
