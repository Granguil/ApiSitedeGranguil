package granguil.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import granguil.data.entity.Module.ModuleStatus;
import granguil.data.mapper.ModuleMapper;
import granguil.data.request.ModuleSaveRequest;
import granguil.data.response.ModuleResponse;
import granguil.data.service.ModuleService;
import granguil.data.service.ResourceService;

@RestController
@RequestMapping("/Module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	ResourceService resourceService;
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/Get")
	public ModuleResponse getModules(){
		ModuleResponse module=new ModuleResponse();
		module=ModuleMapper.getModules(moduleService.getModulesList());
		return module;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/Save")
	public String saveModule(@Validated @RequestBody ModuleSaveRequest module,@RequestAttribute String language) {
		if(moduleService.SaveModule(module)) {
			return resourceService.getValue(language, "saveSuccess");
		}else {
			return resourceService.getValue(language, "saveFail");
		}
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/Update")
	public String updateModule(@Validated @RequestBody ModuleSaveRequest module,@RequestAttribute String language) {
		if(moduleService.UpdateModule(module)) {
			return resourceService.getValue(language, "saveSuccess");
		}else {
			return resourceService.getValue(language, "saveFail");
		}
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(path="/Status")
	public List<ModuleStatus> getStatus (){
		List<ModuleStatus> list=new ArrayList<ModuleStatus>();
		list.add(ModuleStatus.ACTIVE);
		list.add(ModuleStatus.USED);
		list.add(ModuleStatus.ARCHIVED);
		return list;
	}
}
