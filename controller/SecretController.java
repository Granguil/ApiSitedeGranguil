package granguil.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import granguil.data.request.SecretRequest;
import granguil.data.response.SecretResponse;
import granguil.data.service.SecretService;

@RestController
@RequestMapping("/Secret")
public class SecretController {

	@Autowired
	SecretService secretService;
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/Get/{question}")
	public SecretResponse getSecret(@PathVariable(name="question")String question){
		SecretResponse secret=secretService.getResponse(question);
		return secret;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/GetRandom")
	public SecretResponse getRandomSecret(){
		SecretResponse secret=secretService.getRandom();
		return secret;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/add")
	public String saveSecret(@Validated @RequestBody SecretRequest secret) {
		String message=secretService.saveSecret(secret);
		return message;
	}
}
