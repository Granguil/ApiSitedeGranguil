package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.Enum.CurrentState;
import granguil.data.entity.Book;
import granguil.data.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter,UUID>{
Optional<List<Chapter>> findByBookAssociatedAndCurrentState(Book book,CurrentState currentState);
}
