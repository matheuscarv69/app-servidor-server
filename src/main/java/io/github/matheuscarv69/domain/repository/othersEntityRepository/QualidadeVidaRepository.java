package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.QualidadeVida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QualidadeVidaRepository extends JpaRepository<QualidadeVida, Integer> {

    @Override
    Optional<QualidadeVida> findById(Integer integer);
}
