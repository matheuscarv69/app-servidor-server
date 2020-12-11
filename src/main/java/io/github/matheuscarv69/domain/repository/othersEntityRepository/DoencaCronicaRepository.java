package io.github.matheuscarv69.domain.repository.othersEntityRepository;


import io.github.matheuscarv69.domain.entity.othersEntity.DoencaCronica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoencaCronicaRepository extends JpaRepository<DoencaCronica, Integer> {

    @Override
    Optional<DoencaCronica> findById(Integer integer);

}
