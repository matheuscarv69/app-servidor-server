package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Integer> {

    @Override
    Optional<EstadoCivil> findById(Integer integer);

}
