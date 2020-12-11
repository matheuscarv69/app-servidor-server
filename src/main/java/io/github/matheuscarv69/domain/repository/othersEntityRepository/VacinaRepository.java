package io.github.matheuscarv69.domain.repository.othersEntityRepository;

import io.github.matheuscarv69.domain.entity.othersEntity.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VacinaRepository extends JpaRepository<Vacina,Integer> {

    @Override
    Optional<Vacina> findById(Integer integer);
}
