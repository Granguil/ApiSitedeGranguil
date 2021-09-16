package granguil.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.Navigation;
import granguil.data.mapper.NavigationMapper;
import granguil.data.repository.NavigationRepository;
import granguil.data.request.NavigationRequest;
import granguil.data.request.NavigationSaveRequest;
import granguil.data.response.NavigationResponse;

@Service
public class NavigationService {

	@Autowired
	NavigationRepository navigationRepository;
	
	@Autowired
	ResourceService resourceService;
	
	public List<NavigationResponse> getNavigation(NavigationRequest navigationRequest){
		List<Navigation> navigation=navigationRepository.findByRoleAndSite(navigationRequest.getRole(), navigationRequest.getSite()).get();
		List<NavigationResponse> list=NavigationMapper.getNavigationList(navigation);
		return list;
	}
	
	public String saveNavigation(NavigationSaveRequest navigationRequest,String language) {
		Navigation navigation=NavigationMapper.saveNavigation(navigationRequest);
		try {
			navigationRepository.save(navigation);
			return resourceService.getValue(language, "navigationSaved");
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
