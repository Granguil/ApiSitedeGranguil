package granguil.data.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import granguil.data.entity.Setting;

public interface SettingRepository extends JpaRepository<Setting,UUID> {
Optional<Setting> findByCode(UUID code);
}
