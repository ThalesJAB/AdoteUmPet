package br.com.adoteumpet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.adoteumpet.storage.FotoStorage;
import br.com.adoteumpet.storage.s3.FotoStorageS3;

@Service
public class FotoService {

	@Autowired
	private FotoStorage storage = new FotoStorageS3();

	public String salvar(MultipartFile file) {
		return storage.salvar(file);

	}

	public byte[] recuperar(String foto) {
		return storage.recuperar(foto);
	}

	public void excluir(String foto) {
		storage.excluir(foto);
		
	}

	private String renomearArquivo(String nomeOriginal) {
		return storage.renomearArquivo(nomeOriginal);
	}

	public String getUrl(String foto) {
		return storage.getUrl(foto);
	}

}
