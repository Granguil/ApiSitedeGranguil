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

	public String isAuthenticated(String pseudo,UUID roleCode,String token) {
		Role role=roleService.getRoleByCode(roleCode);
		try {
		User user=userRepository.findByPseudoAndRoleAndToken1(pseudo, role, token).get();
		return user.getLanguage();
		}catch(Exception e) {
			return null;
		}
	}
}
