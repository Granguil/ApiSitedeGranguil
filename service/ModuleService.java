package granguil.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.ModuleType;
import granguil.data.entity.Version;
import granguil.data.entity.Module;
import granguil.data.mapper.ModuleMapper;
import granguil.data.repository.ModuleRepository;
import granguil.data.repository.ModuleTypeRepository;
import granguil.data.repository.VersionRepository;
import granguil.data.request.ModuleSaveRequest;

@Service
public class ModuleService {
	
@Autowired
private ModuleTypeRepository moduleTypeRepository;

@Autowired
private ModuleRepository moduleRepository;

@Autowired
private VersionRepository versionRepository;


public List<ModuleType> getModulesList(){
	List<ModuleType> modules=moduleTypeRepository.findAll();
	System.out.println(modules.size());
	return modules;
}

public  boolean SaveModule(ModuleSaveRequest module) {
	try {
		switch(module.getType().getValue()) {
		case 0:case 1:
			Version versionSave=ModuleMapper.getVersion(module);
			Version versionParent=versionRepository.findById(module.getParent()).get();
			versionSave.setVersion_parent(versionParent);
			versionRepository.save(versionSave);
		break;	
		case 2:
			Version versionSaveMajor=ModuleMapper.getVersion(module);
			Module moduleParent=moduleRepository.findById(module.getParent()).get();
			versionSaveMajor.setModule(moduleParent);
			versionRepository.save(versionSaveMajor);
			break;
		case 3:
			Module mod=ModuleMapper.getModule(module);
			ModuleType mt=moduleTypeRepository.findById(module.getParent()).get();
			mod.setType(mt);
			moduleRepository.save(mod);
			break;
		}
		return true;
	}catch(Exception e) {
		return false;
	}
}

public  boolean UpdateModule(ModuleSaveRequest module) {
	try {
		switch(module.getType().getValue()) {
		case 0:case 1:case 2:
			Version version=versionRepository.findById(module.getId()).get();
			version.setDescription(module.getDescription());
			version.setStatus(module.getStatus());
			versionRepository.save(version);
			break;
		case 3:
			Module mod=moduleRepository.findById(module.getId()).get();
			mod.setDescription(module.getDescription());
			mod.setStatus(module.getStatus());
			moduleRepository.save(mod);
			break;
		}
		return true;
	}catch(Exception e) {
		System.out.println(e.getMessage());
		return false;
	}
}

}
