package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.DeficienteFamilia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeficienteFamiliaRepository extends JpaRepository<DeficienteFamilia, Integer> {

    @Override
    Optional<DeficienteFamilia> findById(Integer integer);

}

