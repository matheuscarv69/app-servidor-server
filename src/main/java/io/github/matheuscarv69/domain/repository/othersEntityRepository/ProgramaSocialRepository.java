package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.ProgramaSocial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramaSocialRepository extends JpaRepository<ProgramaSocial, Integer> {

    @Override
    Optional<ProgramaSocial> findById(Integer integer);
}
