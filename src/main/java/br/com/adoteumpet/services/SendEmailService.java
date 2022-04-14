package br.com.adoteumpet.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class SendEmailService {

	@Autowired
	private final JavaMailSender envioEmaildoJava;

	public SendEmailService(final JavaMailSender javaMailSender) {
		this.envioEmaildoJava = javaMailSender;
	}

	public void send(String destino, String titulo, String conteudo) {
		//log.info("Enviando email para confirmação de cadastro...");
		
		try {
		MimeMessage mensagem = envioEmaildoJava.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);
		
		
		helper.setTo(destino);
		helper.setSubject(titulo);
		helper.setText(conteudo, true);
		envioEmaildoJava.send(mensagem);
		
		} catch(Exception e) {
			System.out.println("Erro ao enviar email");
		}
		
		//log.info("Email enviado com sucesso");
		 
	}

}
