package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeneficioRepository extends JpaRepository<Beneficio, Integer> {

    @Override
    Optional<Beneficio> findById(Integer integer);
}
