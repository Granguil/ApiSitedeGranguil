package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.EnumList;

public interface EnumRepository extends JpaRepository<EnumList,UUID>{
Optional<EnumList> findByCode(UUID code);
}
