package granguil.data.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.Secret;
import granguil.data.mapper.SecretMapper;
import granguil.data.repository.SecretRepository;
import granguil.data.request.SecretRequest;
import granguil.data.response.SecretResponse;

@Service
public class SecretService {

	@Autowired
	SecretRepository SR;
	
	public SecretResponse getResponse(String question) {
		Secret secret=SR.findByQuestion(question).get();
		SecretResponse secretResponse=SecretMapper.getSecret(secret);
		return secretResponse;
	}
	
	public String saveSecret(SecretRequest secret) {
		Secret secretToSave=SecretMapper.saveSecret(secret);
		try {
		SR.save(secretToSave);
		return "Secret Enregistré";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	public SecretResponse getRandom() {
		List<Secret> secrets=SR.findAll();
		Random rnd=new Random();
		int bound=secrets.size();
		Secret secret=secrets.get(rnd.nextInt(bound));
		SecretResponse secretResponse=SecretMapper.getSecret(secret);
		return secretResponse;
	}
}
