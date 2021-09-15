package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Display;

public interface DisplayRepository extends JpaRepository<Display,UUID>{
Optional<Display> findByCode(UUID code);
}
