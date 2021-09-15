package granguil.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Navigation;

public interface NavigationRepository extends JpaRepository<Navigation,Integer>{
Optional<List<Navigation>> findByRoleAndSite(UUID role,String site);
}
