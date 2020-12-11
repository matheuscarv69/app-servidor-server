package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.Residencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidenciaRepository extends JpaRepository<Residencia, Integer> {

    @Override
    Optional<Residencia> findById(Integer integer);
}
