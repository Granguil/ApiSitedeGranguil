package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Book;
import granguil.data.entity.Chapter;
import granguil.data.entity.ReadUser;
import granguil.data.entity.Scene;
import granguil.data.entity.Universe;
import granguil.data.entity.User;

public interface ReadUserRepository extends JpaRepository<ReadUser,UUID> {
Optional<List<ReadUser>> findByUserAndUniverseOrUserAndBookOrUserAndChapterOrUserAndScene(User user,Universe universe,User user2,Book book,User user3, Chapter chapter, User user4,Scene scene);
Optional<List<ReadUser>> findByUser(User user);
}
