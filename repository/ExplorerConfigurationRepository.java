package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.ExplorerConfiguration;

public interface ExplorerConfigurationRepository extends JpaRepository<ExplorerConfiguration,UUID>{
Optional<ExplorerConfiguration> findByName(String name);
}
