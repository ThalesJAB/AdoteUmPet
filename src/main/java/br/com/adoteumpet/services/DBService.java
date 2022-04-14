package br.com.adoteumpet.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adoteumpet.entities.Endereco;
import br.com.adoteumpet.entities.Usuario;
import br.com.adoteumpet.repositories.EnderecoRepository;
import br.com.adoteumpet.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	
	public void instanciaBasedeDados() {

		Usuario usuario1 = new Usuario(null, "thalespro", "1234", "thalesjoseaguiar@gmail.com", "Thales José",
				"232323232324", "(81)98694-8019", "minha vida é assim", null, null, true);
		Usuario usuario2 = new Usuario(null, "xbeliscao", "1234", "otavio.silva@aluno.uniaeso.edu.br", "Otavio Augusto",
				"89238923", "(81)93233-4423", "minha vida é assim", null, null, true);
		Usuario usuario3 = new Usuario(null, "edvaldoprogamer", "1234", "edvaldo.santana@aluno.uniaeso.edu.br", "Edvaldo Junior",
				"2423435", "(81)96455-3435", "minha vida é assim", null, null, true);

		Endereco endereco1 = new Endereco(null, "53260-380", "Rua Débora Regis de Carvalho", "160", "Olinda", "Pernambuco");
		Endereco endereco2 = new Endereco(null, "53244-340", "Rua do Galeto", "334", "Olinda", "Pernambuco");
		Endereco endereco3 = new Endereco(null, "51383-675", "Rua da Nordibe", "424", "Olinda", "Pernambuco");

		this.usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
		
		
		this.enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));

		usuario1.setEndereco(endereco1);

		usuario2.setEndereco(endereco2);

		usuario3.setEndereco(endereco3);

		this.usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
		this.enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
		

// ================================Testes Email====================================================
//		Usuario usuario1 = new Usuario(null, "thalespro", "1234", "thalesjoseaguiar@gmail.com", "Thales José",
//				"232323232324", "(81)98694-8019", "minha vida é assim", null, null, true);
//		Usuario usuario11 = new Usuario(null, "thalespro", "1234", "thales.batista@aluno.uniaeso.br", "Thales José",
//				"232323232324", "(81)98694-8019", "minha vida é assim", null, null, true);
//		Usuario usuario2 = new Usuario(null, "xbeliscao", "1234", "otavio.silva@aluno.uniaeso.edu.br", "Otavio Augusto",
//				"89238923", "(81)93233-4423", "minha vida é assim", null, null, true);
//		Usuario usuario3 = new Usuario(null, "edvaldoprogamer", "1234", "edvaldo.santana@aluno.uniaeso.edu.br", "Edvaldo Junior",
//				"2423435", "(81)96455-3435", "minha vida é assim", null, null, true);
		
		
		
		
		
		
//		Usuario usuario1 = new Usuario(null, "josivangameplays", "1234", "josivan.silva@aluno.uniaeso.edu.br", "Josivan Junior",
//				"232323232324", "(81)98782-4424", "minha vida é assim", null, null, true);
//		Usuario usuario2 = new Usuario(null, "romuloLolzinho", "1234", "romulo.cunha@aluno.uniaeso.edu.br", "Romulo Pericles",
//				"89238923", "(81)93233-4423", "minha vida é assim", null, null, true);
//		Usuario usuario3 = new Usuario(null, "georghitonzin", "1234", "georghiton@gmail.com", "Georghiton da Silva",
//				"2423435", "(81)96455-3435", "minha vida é assim", null, null, true);
//	
//		
//		usuarioService.create(usuario1);
//		usuarioService.create(usuario2);
//		usuarioService.create(usuario3);

	}

}
