package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.AssociatedCode;
import granguil.data.entity.Code;

public interface AssociatedCodeRepository extends JpaRepository<AssociatedCode,UUID>{
Optional<AssociatedCode> findByCode(Code code);
}
