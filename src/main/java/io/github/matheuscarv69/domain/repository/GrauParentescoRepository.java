package io.github.matheuscarv69.domain.repository;

import io.github.matheuscarv69.domain.entity.othersEntity.GrauParentesco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrauParentescoRepository extends JpaRepository<GrauParentesco, Integer> {

    @Override
    Optional<GrauParentesco> findById(Integer integer);
}
