package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.ModuleType;

public interface ModuleTypeRepository extends JpaRepository<ModuleType,UUID>{
Optional<List<ModuleType>> findByCode(UUID code);
}
