package granguil.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.ExplorerConfiguration;
import granguil.data.repository.ExplorerConfigurationRepository;
import granguil.data.request.ExplorerConfigurationRequest;
import granguil.data.response.ExplorerConfigurationResponse;
import granguil.data.response.StringResponse;


@Service
public class ExplorerConfigurationService {
@Autowired
private ExplorerConfigurationRepository ecr;

	public ExplorerConfigurationResponse getConfiguration(String name) {
		ExplorerConfiguration ec=ecr.findByName(name).get();
		ExplorerConfigurationResponse configResponse=new ExplorerConfigurationResponse();
		configResponse.setCode(ec.getCode());
		configResponse.setName(ec.getName());
		configResponse.setCardNumber(ec.getCardNumber());
		configResponse.setDisplayAll(ec.isDisplayAll());
		configResponse.setLoadAll(ec.isLoadAll());
		configResponse.setWithInfo(ec.isWithInfo());
		configResponse.setInfoPopup(ec.isInfoPopup());
		return configResponse;
	}
	
	public StringResponse setConfiguration(ExplorerConfigurationRequest config) {
		StringResponse message=new StringResponse();
		try {
		ExplorerConfiguration ec=ecr.findByName(config.getName()).get();
		ec.setDisplayAll(config.isDisplayAll());
		ec.setLoadAll(config.isLoadAll());
		ec.setWithInfo(config.isWithInfo());
		ec.setInfoPopup(config.isInfoPopup());
		ecr.save(ec);
		message.setMessage("Sauvegarde Réussie");
		}catch(Exception e) {
			message.setMessage(e.getMessage());
		}
		
		return message;
	}
}
