package br.com.adoteumpet.storage;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	public String salvar(MultipartFile file);

	public byte[] recuperar(String foto);

	public void excluir(String foto);

	public String getUrl(String foto);

	default String renomearArquivo(String nomeOriginal) {
		return UUID.randomUUID().toString() + "_" + nomeOriginal;
	}

}
