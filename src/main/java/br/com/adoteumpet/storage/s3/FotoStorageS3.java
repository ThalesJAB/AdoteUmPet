package br.com.adoteumpet.storage.s3;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;

import br.com.adoteumpet.storage.FotoStorage;

@Component
public class FotoStorageS3 implements FotoStorage {

	private static final String BUCKET = "adoteumpet";

	@Autowired
	private AmazonS3 amazonS3;

	public String salvar(MultipartFile file) {
		String novoNome = null;
		if (file != null && !file.isEmpty()) {
			MultipartFile arquivo = file;
			novoNome = renomearArquivo(arquivo.getOriginalFilename());
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(arquivo.getContentType());
			metadata.setContentLength(arquivo.getSize());
			AccessControlList acl = new AccessControlList();
			acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
			try {
				amazonS3.putObject(new PutObjectRequest(BUCKET, novoNome, arquivo.getInputStream(), metadata)
						.withAccessControlList(acl));
			} catch (IOException e) {
				throw new RuntimeException("Erro salvando arquivo no S3", e);
			}

		}
		return novoNome;
	}

	public byte[] recuperar(String foto) {
		InputStream is = amazonS3.getObject(BUCKET, foto).getObjectContent();
		try {
			return IOUtils.toByteArray(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir(String foto) {
		amazonS3.deleteObjects(new DeleteObjectsRequest(BUCKET).withKeys(foto));

	}

	@Override
	public String getUrl(String foto) {
		if (!StringUtils.isEmpty(foto)) {
			return "https://adoteumpet.s3.sa-east-1.amazonaws.com/" + foto;
		}

		return null;
	}

}
