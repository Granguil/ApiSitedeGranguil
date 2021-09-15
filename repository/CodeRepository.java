package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Code;

public interface CodeRepository extends JpaRepository<Code,UUID> {
Optional<Code> findByCode(UUID code);
Optional<List<Code>> findByTableName(String tableName);
}
