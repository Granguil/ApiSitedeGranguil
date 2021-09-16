package granguil.data.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.Resource;
import granguil.data.entity.ResourceForServer;
import granguil.data.mapper.ResourceMapper;
import granguil.data.repository.ResourceForServerRepository;
import granguil.data.repository.ResourceRepository;
import granguil.data.request.ResourceRequest;

@Service
public class ResourceService {
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	ResourceForServerRepository serverRepository;
	
	public Map<String,Object> getResources (String language,String site){
		List<String> siteandgeneral=new ArrayList<> (Arrays.asList("General",site));
		List<Resource> resourcesListByDefault=resourceRepository.findByLanguageAndSiteNameIn("Fra",siteandgeneral).get();
		List<Resource> resourcesList=new ArrayList<Resource>();
		boolean languageByDefault=true;
		if(!language.equals("Fra")) {
		resourcesList=resourceRepository.findByLanguageAndSiteNameIn(language,siteandgeneral).get();
		languageByDefault=false;
		}
		Collections.sort(resourcesListByDefault, new Comparator<Resource>() {
		    public int compare(Resource r1, Resource r2) {
		        return r1.getGroup().compareTo(r2.getGroup());
		    }
		});
		Collections.sort(resourcesList, new Comparator<Resource>() {
		    public int compare(Resource r1, Resource r2) {
		        return r1.getGroup().compareTo(r2.getGroup());
		    }
		});
		Map<String,Object> resources = ResourceMapper.associate(resourcesList,resourcesListByDefault,languageByDefault);
		return resources;
	}
	
	public String addResources (ResourceRequest resourceRequest,String language) {
		Resource resource=new Resource();
		resource.setLanguage(resourceRequest.getLanguage());
		resource.setName(resourceRequest.getKey());
		resource.setValue(resourceRequest.getValue());
		try {
		resourceRepository.save(resource);
		return this.getValue(language, "resourceSaved");
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	public String getValue(String language,String name) {
		try {
		ResourceForServer rfc= serverRepository.findByLanguageAndName(language, name).get();
		return rfc.getValue();
		}catch(Exception e) {
			return name;
		}
	}
}
