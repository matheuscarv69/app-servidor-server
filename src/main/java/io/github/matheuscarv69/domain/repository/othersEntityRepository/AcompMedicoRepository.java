package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.AcompMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcompMedicoRepository extends JpaRepository<AcompMedico,Integer> {

    @Override
    Optional<AcompMedico> findById(Integer integer);
}
