package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Role;

public interface RoleRepository extends JpaRepository<Role,UUID>{
Optional<Role> findByCode(UUID code);
}
