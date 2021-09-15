package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission,UUID>{
Optional<Permission> findByCode(UUID code);
}
