package granguil.data.mapper;

import granguil.data.entity.Secret;
import granguil.data.request.SecretRequest;
import granguil.data.response.SecretResponse;

public class SecretMapper {

	public static SecretResponse getSecret(Secret secret) {
		SecretResponse response=new SecretResponse();
		response.setQuestion(secret.getQuestion());
		response.setResponse(secret.getResponse());
		return response;
	}
	
	public static Secret saveSecret(SecretRequest secretRequest) {
		Secret secret=new Secret();
		secret.setQuestion(secretRequest.getQuestion());
		secret.setResponse(secretRequest.getResponse());
		return secret;
	}
}
