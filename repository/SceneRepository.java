package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.Enum.CurrentState;
import granguil.data.entity.Chapter;
import granguil.data.entity.Scene;

public interface SceneRepository extends JpaRepository<Scene,UUID>{
Optional<List<Scene>> findByChapterAssociatedAndCurrentState(Chapter chapter,CurrentState currentState);
}
