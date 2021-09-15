package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.BookMark;
import granguil.data.entity.User;

public interface BookMarkRepository extends JpaRepository<BookMark,UUID> {
Optional<List<BookMark>> findByUser(User user);
}
