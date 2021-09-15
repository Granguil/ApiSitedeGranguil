package granguil.data.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.Enum.TypeRole;
import granguil.data.entity.Role;
import granguil.data.repository.RoleRepository;

@Service
public class RoleService {
@Autowired
RoleRepository roleRepository;

	public TypeRole getTypeOfRole(UUID codeRole) {
		Role role=roleRepository.findByCode(codeRole).get();
		return role.getTypeRole();
	}
	
	public Role getRoleByCode(UUID code) {
		Role role=roleRepository.findByCode(code).get();
		return role;
	}
}
