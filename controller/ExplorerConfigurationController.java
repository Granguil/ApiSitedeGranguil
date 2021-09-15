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

import granguil.data.request.ExplorerConfigurationRequest;
import granguil.data.response.ExplorerConfigurationResponse;
import granguil.data.response.StringResponse;
import granguil.data.service.ExplorerConfigurationService;

@RestController
@RequestMapping("/Explorer")
public class ExplorerConfigurationController {

	@Autowired
	ExplorerConfigurationService ecs;
	
	@CrossOrigin(origins="*")
	@GetMapping("/GetConfig/{name}")
	public ExplorerConfigurationResponse getConfig(@PathVariable(name="name")String name) {
		ExplorerConfigurationResponse ecr=ecs.getConfiguration(name);
		return ecr;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/SetConfig")
	public StringResponse setConfig(@RequestBody @Validated ExplorerConfigurationRequest ecr) {
		return ecs.setConfiguration(ecr);
	}
}
