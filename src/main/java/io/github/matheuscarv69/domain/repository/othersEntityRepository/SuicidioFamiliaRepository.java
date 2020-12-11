package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.SuicidioFamilia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuicidioFamiliaRepository extends JpaRepository<SuicidioFamilia, Integer> {

    @Override
    Optional<SuicidioFamilia> findById(Integer integer);
}
