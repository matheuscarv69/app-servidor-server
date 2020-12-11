package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.AtividadeFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtividadeFisicaRepository extends JpaRepository<AtividadeFisica, Integer> {

    @Override
    Optional<AtividadeFisica> findById(Integer integer);
}
