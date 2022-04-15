package br.com.adoteumpet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adoteumpet.entities.ONG;
import br.com.adoteumpet.repositories.ONGRepository;

@Service
public class ONGService {
	
	@Autowired
	private ONGRepository repository;
	
	@Autowired
	private SendEmailService sendEmailService;

	public List<ONG> findAll() {
		return repository.findAll();
	}
	
	
	
	
	

}
