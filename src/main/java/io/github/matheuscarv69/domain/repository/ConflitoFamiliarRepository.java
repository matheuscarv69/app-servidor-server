package io.github.matheuscarv69.domain.repository;

import io.github.matheuscarv69.domain.entity.othersEntity.ConflitoFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConflitoFamiliarRepository extends JpaRepository<ConflitoFamiliar, Integer> {

    @Override
    Optional<ConflitoFamiliar> findById(Integer integer);
}
