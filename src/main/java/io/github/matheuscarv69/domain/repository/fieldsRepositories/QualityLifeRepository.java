package io.github.matheuscarv69.domain.repository.fieldsRepositories;

import io.github.matheuscarv69.domain.entity.fields.QualityLife;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QualityLifeRepository extends JpaRepository<QualityLife, Integer> {

    @Override
    Optional<QualityLife> findById(Integer integer);
}
