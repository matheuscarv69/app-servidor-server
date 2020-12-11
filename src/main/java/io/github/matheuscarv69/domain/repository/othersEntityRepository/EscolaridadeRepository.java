package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.Escolaridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Integer> {

    @Override
    Optional<Escolaridade> findById(Integer integer);
}
