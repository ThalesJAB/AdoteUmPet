package br.com.adoteumpet.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.adoteumpet.dtos.ONGDTO;
import br.com.adoteumpet.email.EmailMessagesUsuario;
import br.com.adoteumpet.entities.ONG;
import br.com.adoteumpet.entities.Usuario;
import br.com.adoteumpet.repositories.UsuarioRepository;
import br.com.adoteumpet.services.exceptions.ObjectNotFoundException;
import br.com.adoteumpet.storage.s3.FotoStorageS3;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ONGService ongService;

	@Autowired
	private SendEmailService sendEmailService;
	
	@Autowired
	private FotoStorageS3 fotoStorage;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}

	public Usuario create(Usuario obj) {
		obj.setId(null);
		

		Usuario usuarioNovo = repository.save(obj);
		
		

		//this.sendEmailService.send(usuarioNovo.getEmail(), EmailMessagesUsuario.createTitle(usuarioNovo), EmailMessagesUsuario.messageToNewUser(usuarioNovo));
		
		
		
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

		organizarOngs(usuario, obj.getOngsFavoritas());
	
		System.out.println("=============== DALE DALE =====================");
		//usuario.getOngsFiliadas().forEach(System.out::println);
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
	
	
	
	
	
	private void organizarOngs(Usuario usuario, List<ONGDTO> ongsJson) {
		List<ONGDTO> newListOng = new ArrayList<>();
		boolean possui = false;
		for (ONGDTO ongObjJson : ongsJson) {

			for (ONGDTO ongUsuario : usuario.getOngsFavoritas()) {

				if (ongUsuario.equals(ongObjJson)) {
					possui = true;
					break;
				}

			}

			if (!possui) {
				newListOng.add(ongObjJson);

			}

			possui = false;

		}

		for (ONGDTO ongObjNew : newListOng) {

			ONG ong = new ONG();
			ong.setId(ongObjNew.getId());
			ong.setRazaoSocial(ongObjNew.getRazaoSocial());
			ong.setNomeFantasia(ongObjNew.getNomeFantasia());
			ong.setCnpj(ongObjNew.getCnpj());
			ong.setEmail(ongObjNew.getEmail());
			ong.setBiografia(ongObjNew.getBiografia());
			ong.setEndereco(ongObjNew.getEndereco());
			ong.setImagem(ongObjNew.getImagem());
			ong.setStatus(ongObjNew.getStatus());

			usuario.addOngsFavoritas(ong);
		}
	}

}
