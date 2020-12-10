package io.github.matheuscarv69.domain.repository;

import io.github.matheuscarv69.domain.entity.othersEntity.Violencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViolenciaRepository extends JpaRepository<Violencia,Integer> {

    @Override
    Optional<Violencia> findById(Integer integer);
}
