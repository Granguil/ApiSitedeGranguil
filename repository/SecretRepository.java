package granguil.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Secret;

public interface SecretRepository extends JpaRepository<Secret,Integer>{
Optional<Secret> findByQuestion(String question);
}
