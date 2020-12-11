package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.AtividadeLazer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtividadeLazerRepository extends JpaRepository<AtividadeLazer, Integer> {

    @Override
    Optional<AtividadeLazer> findById(Integer integer);
}
