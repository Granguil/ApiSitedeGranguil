package granguil.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import granguil.data.request.NavigationRequest;
import granguil.data.request.NavigationSaveRequest;
import granguil.data.response.NavigationResponse;
import granguil.data.service.NavigationService;

@RestController
@RequestMapping("/Navigation")
public class NavigationController {

	@Autowired
	NavigationService navigationService;
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/Get")
	public List<NavigationResponse> getNavigation(@Validated @RequestBody NavigationRequest navigationRequest){
		List<NavigationResponse> list=navigationService.getNavigation(navigationRequest);
		return list;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/add")
	public String saveNavigation(@Validated @RequestBody NavigationSaveRequest navigation) {
		return navigationService.saveNavigation(navigation);
	}
}
