package granguil.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Module;

public interface ModuleRepository extends JpaRepository<Module,UUID>{

}
