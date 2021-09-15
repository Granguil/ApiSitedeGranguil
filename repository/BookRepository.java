package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.Enum.CurrentState;
import granguil.data.entity.Book;
import granguil.data.entity.Universe;

public interface BookRepository extends JpaRepository<Book,UUID>{
Optional<List<Book>> findByUniverseAssociatedAndCurrentState(Universe universe,CurrentState currentState);
Optional<Book> findByTitle(String title);
}
