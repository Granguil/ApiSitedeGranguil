package granguil.data.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import granguil.data.Enum.TypeRole;
import granguil.data.service.RoleService;

@RestController
@RequestMapping("/Role")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@CrossOrigin(origins="*")
	@GetMapping("/GetType")
	public TypeRole getRoleType(@RequestParam(name="idrole") String id) {
		return roleService.getTypeOfRole(UUID.fromString(id));
	}
}
