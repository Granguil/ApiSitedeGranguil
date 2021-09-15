package granguil.data.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import granguil.data.request.ResourceRequest;
import granguil.data.service.ResourceService;

@RestController
@RequestMapping("/Resources")
public class ResourceController {

	@Autowired
	ResourceService resourceService;
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/{site}/{lang}")
	public Map<String,Object> getPath(@PathVariable(name="site")String site,@PathVariable(name="lang")String lang) {
		System.out.println(site+" & "+lang);
		Map<String,Object> resourcesList=resourceService.getResources(lang,site);
		return resourcesList;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/add")
	public String saveResource (@Validated @RequestBody ResourceRequest resource) {
		return resourceService.addResources(resource);
	}
}
