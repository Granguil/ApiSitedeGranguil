package granguil.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Resource;
import granguil.data.utils.ResourceKey;

public interface ResourceRepository extends JpaRepository<Resource,ResourceKey> {
Optional<List<Resource>> findByLanguageAndNameAndSiteNameIn(String language,String name,List<String> sites);
Optional<List<Resource>> findByLanguageAndSiteNameIn(String language,List<String> sites);
}
