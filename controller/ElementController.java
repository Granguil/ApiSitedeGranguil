package granguil.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import granguil.data.entity.AssociatedCode;
import granguil.data.entity.Code;
import granguil.data.service.AssociatedCodeService;
import granguil.data.service.CodeService;

@RestController
@RequestMapping("/Element")
public class ElementController {
	@Autowired
	CodeService codeService;
	
	@Autowired
	AssociatedCodeService ACS;
	
	@CrossOrigin(origins="*")
	@GetMapping("/Get")
	public List<Code> getCode(){
		List<Code> list=codeService.getMapObject();
		return list;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/GetAttachedElements")
	public AssociatedCode getAttachedElements(){
		List<Code> list=codeService.getMapObject();
		System.out.println("Code : "+list.get(0).getCode());
		AssociatedCode elements=ACS.getAssociatedElement(list.get(0));
		return elements;
	}
}
