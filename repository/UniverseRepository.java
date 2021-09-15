package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.Enum.CurrentState;
import granguil.data.entity.Universe;

public interface UniverseRepository extends JpaRepository<Universe,UUID>{
Optional<Universe> findByTitle(String title);
Optional<List<Universe>> findByCurrentState(CurrentState currentState);
}
