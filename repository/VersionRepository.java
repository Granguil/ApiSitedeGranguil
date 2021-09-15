package granguil.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Version;

public interface VersionRepository extends JpaRepository<Version,UUID>{

}
