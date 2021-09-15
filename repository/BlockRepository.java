package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Block;
import granguil.data.entity.Scene;

public interface BlockRepository extends JpaRepository<Block,UUID>{
Optional<List<Block>> findBySceneAssociated(Scene scene);
}
