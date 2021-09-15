package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Role;
import granguil.data.entity.User;

public interface UserRepository extends JpaRepository<User,UUID>{
Optional<User> findByUserCode(UUID code);
Optional<User> findByPseudo(String pseudo);
Optional<User> findByRole(Role role);
Optional<User> findByPseudoAndRoleAndToken1(String pseudo,Role role, String Token);
}
