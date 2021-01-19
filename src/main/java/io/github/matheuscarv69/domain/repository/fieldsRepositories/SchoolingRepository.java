package io.github.matheuscarv69.domain.repository.fieldsRepositories;

import io.github.matheuscarv69.domain.entity.fields.Schooling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolingRepository extends JpaRepository<Schooling, Integer> {

    @Override
    Optional<Schooling> findById(Integer integer);
}
