package br.com.adoteumpet.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adoteumpet.entities.Animal;
import br.com.adoteumpet.entities.Endereco;
import br.com.adoteumpet.entities.ONG;
import br.com.adoteumpet.entities.PlanoUsuarioFiliado;
import br.com.adoteumpet.entities.Usuario;
import br.com.adoteumpet.repositories.AnimalRepository;
import br.com.adoteumpet.repositories.EnderecoRepository;
import br.com.adoteumpet.repositories.ONGRepository;
import br.com.adoteumpet.repositories.PlanoUsuarioFiliadoRepository;
import br.com.adoteumpet.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ONGRepository ongRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private PlanoUsuarioFiliadoRepository usuarioFiliadoRepository;

	@Autowired
	private UsuarioService usuarioService;

	private List<Usuario> listUsuariosTeste = new ArrayList<>();
	private List<ONG> listONGSTeste = new ArrayList<>();

	public void instanciaBasedeDados() {

		instanciariOngs();
		instanciarUsuarios();
		instUsuarioOngFiliadasBidirecional();
		instanciarAnimais();
		

	}

	private void instanciarAnimais() {
		ONG ong = this.listONGSTeste.get(0);
		Animal animal1 = new Animal(null, "Lulu", "Viralata","Fêmea", 5, 8.2, "Um pouco arisca", "Lorem ipsum dolor sit amet", null, false, true, ong );
		Animal animal2 = new Animal(null, "Zeus", "Viralata","Macho", 3, 5.3, "Bem dócil", "Lorem ipsum dolor sit amet", null, false, true, ong );
		Animal animal3 = new Animal(null, "Mel", "Viralata","Fêmea", 7, 10.0, "Velha senhora", "Lorem ipsum dolor sit amet", null, false, true, ong );
		//Animal animal1 = new Animal(null, "Lulu", "Viralata", 5, 78.3, "Um pouco arisca", "Lorem ipsum dolor sit amet", null, false, true, ong );
		this.animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3));
		
		
	}

	// =============================Usuarios
	// Teste==========================================
	public void instanciarUsuarios() {

		Usuario usuario1 = new Usuario(null, "thalespro", "1234", "thalesjoseaguiar@gmail.com", "Thales José",
				"411.787.410-10", "(81)98694-8019", "minha vida é assim", null, null, true);
		Usuario usuario2 = new Usuario(null, "xbeliscao", "1234", "otavio.silva@aluno.uniaeso.edu.br", "Otavio Augusto",
				"956.452.770-82", "(81)93233-4423", "minha vida é assim", null, null, true);
		Usuario usuario3 = new Usuario(null, "edvaldoprogamer", "1234", "edvaldo.santana@aluno.uniaeso.edu.br",
				"Edvaldo Junior", "686.524.350-14", "(81)96455-3435", "minha vida é assim", null, null, true);

		Endereco endereco1 = new Endereco(null, "53260-380", "Rua Débora Regis de Carvalho", "160","Peixinhos", "Olinda",
				"Pernambuco");
		Endereco endereco2 = new Endereco(null, "53244-340", "Rua do Galeto", "334", "Peixinhos", "Olinda", "Pernambuco");
		Endereco endereco3 = new Endereco(null, "51383-675", "Rua da Nordibe", "424", "Peixinhos", "Olinda", "Pernambuco");
		
		System.out.println("============================================== Instanciou =================================================");

		this.usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));

		this.enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));

		usuario1.setEndereco(endereco1);

		usuario2.setEndereco(endereco2);

		usuario3.setEndereco(endereco3);

		this.usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));

		this.listUsuariosTeste.addAll(Arrays.asList(usuario1, usuario2, usuario3));
		System.out.println("============================================== Passou =================================================");


	}

	// ============================ONGS
	// Teste==============================================
	public void instanciariOngs() {

		ONG ong1 = new ONG(null, "Roberto X", "ONG amigos dos pets", "78.372.123/0001-40", "amigosdospets@gmail.com",
				"amigospet", "1234", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas neque.", "23232323",null,
				null, true);
		ONG ong2 = new ONG(null, "Gilberto Y", "ONG PETzadas", "22.334.415/0001-34", "petzadas@gmail.com", "petzada",
				"1234", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas neque.", "23232323", null, null, true);
		ONG ong3 = new ONG(null, "Machado Z", "ONG PETlife", "36.623.180/0001-05", "petlife@gmail.com", "petlife", "1234",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas neque.", "23232323", null, null, true);

		Endereco enderecoOng1 = new Endereco(null, "54323-380", "Rua 1", "160", "Peixinhos", "Olinda",  "Pernambuco");
		Endereco enderecoOng2 = new Endereco(null, "45632-340", "Rua 2", "334", "Peixinhos","Olinda", "Pernambuco");
		Endereco enderecoOng3 = new Endereco(null, "45664-675", "Rua 3", "424", "Peixinhos","Olinda", "Pernambuco");

		this.ongRepository.saveAll(Arrays.asList(ong1, ong2, ong3));

		this.enderecoRepository.saveAll(Arrays.asList(enderecoOng1, enderecoOng2, enderecoOng3));

		ong1.setEndereco(enderecoOng1);

		ong2.setEndereco(enderecoOng2);

		ong3.setEndereco(enderecoOng3);

		this.ongRepository.saveAll(Arrays.asList(ong1, ong2, ong3));

		this.listONGSTeste.addAll(Arrays.asList(ong1, ong2, ong3));

	}

	// =============================== USUARIO E ONG MAPEADOS/FILIADOS *MAPEAMENTO
	// BIDIRECIONAL* ==============================

	private void instUsuarioOngFiliadasBidirecional() {
		/*

		for (ONG ong : this.listONGSTeste) {
			for (Usuario usuario : this.listUsuariosTeste) {
				usuario.addOngsFiliadas(ong);
			}
		}
		
		for (Usuario usuario : this.listUsuariosTeste) {
			for (ONG ong : this.listONGSTeste) {
				ong.addUsuariosColaboradores(usuario);
			}
		}
		
		this.usuarioRepository.saveAll(this.listUsuariosTeste);
		this.ongRepository.saveAll(this.listONGSTeste);
		
		*/
		
		Usuario usuario = this.listUsuariosTeste.get(0);
		Usuario usuario2 = this.listUsuariosTeste.get(1);
		ONG ong = this.listONGSTeste.get(0);
		ONG ong2 = this.listONGSTeste.get(1);
		
		PlanoUsuarioFiliado ongFiliada = new PlanoUsuarioFiliado(null, ong, usuario, String.valueOf(Instant.now()), 50.0, 5, true);
		PlanoUsuarioFiliado ongFiliada2 = new PlanoUsuarioFiliado(null, ong2, usuario,  String.valueOf(Instant.now()), 78.0, 5, true);
		PlanoUsuarioFiliado ongFiliada3 = new PlanoUsuarioFiliado(null, ong2, usuario2,  String.valueOf(Instant.now()), 100.0, 3, true);
		System.out.println("=====================================================================================\n====================");
		System.out.println(String.valueOf(Instant.now()));
		this.usuarioFiliadoRepository.save(ongFiliada);
		this.usuarioFiliadoRepository.save(ongFiliada2);
		this.usuarioFiliadoRepository.save(ongFiliada3);
		
		
//		usuario.addOngsFiliadas(ongFiliada);
//		
//
		//this.usuarioRepository.save(usuario);
		//this.ongRepository.save(ong);
		
		
		System.out.println("Protno");

	}

	// ================================Testes
	// Email====================================================

	public void testeEmailUsuario() {

		Usuario usuario1 = new Usuario(null, "thalespro", "1234", "thalesjoseaguiar@gmail.com", "Thales José",
				"232323232324", "(81)98694-8019", "minha vida é assim", null, null, true);
		Usuario usuario11 = new Usuario(null, "thalespro", "1234", "thales.batista@aluno.uniaeso.br", "Thales José",
				"232323232324", "(81)98694-8019", "minha vida é assim", null, null, true);
		Usuario usuario2 = new Usuario(null, "xbeliscao", "1234", "otavio.silva@aluno.uniaeso.edu.br", "Otavio Augusto",
				"89238923", "(81)93233-4423", "minha vida é assim", null, null, true);
		Usuario usuario3 = new Usuario(null, "edvaldoprogamer", "1234", "edvaldo.santana@aluno.uniaeso.edu.br",
				"Edvaldo Junior", "2423435", "(81)96455-3435", "minha vida é assim", null, null, true);
//
//		Usuario usuario1 = new Usuario(null, "josivangameplays", "1234", "josivan.silva@aluno.uniaeso.edu.br",
//				"Josivan Junior", "232323232324", "(81)98782-4424", "minha vida é assim", null, null, true);
//		Usuario usuario2 = new Usuario(null, "romuloLolzinho", "1234", "romulo.cunha@aluno.uniaeso.edu.br",
//				"Romulo Pericles", "89238923", "(81)93233-4423", "minha vida é assim", null, null, true);
//		Usuario usuario3 = new Usuario(null, "georghitonzin", "1234", "georghiton@gmail.com", "Georghiton da Silva",
//				"2423435", "(81)96455-3435", "minha vida é assim", null, null, true);

//		usuarioService.create(usuario1);
//		usuarioService.create(usuario2);
//		usuarioService.create(usuario3);

	}

}
