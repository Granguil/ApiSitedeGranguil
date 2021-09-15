package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.File;

public interface FileRepository extends JpaRepository<File,UUID>{
Optional<File> findByName(String name);
}
