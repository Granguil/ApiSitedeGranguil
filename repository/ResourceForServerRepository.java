package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.ResourceForServer;

public interface ResourceForServerRepository extends JpaRepository<ResourceForServer,UUID>{
Optional<ResourceForServer> findByLanguageAndName(String language,String name);
}
