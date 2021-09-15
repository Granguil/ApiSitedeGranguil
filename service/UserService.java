package granguil.data.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granguil.data.entity.Role;
import granguil.data.entity.User;
import granguil.data.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;

	public boolean isAuthenticated(String pseudo,UUID roleCode,String token) {
		Role role=roleService.getRoleByCode(roleCode);
		try {
		userRepository.findByPseudoAndRoleAndToken1(pseudo, role, token).get();
		return true;
		}catch(Exception e) {
			return false;
		}
	}
}
