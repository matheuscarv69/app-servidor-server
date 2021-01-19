package io.github.matheuscarv69.domain.repository.fieldsRepositories;

import io.github.matheuscarv69.domain.entity.fields.Kinship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KinshipRepository extends JpaRepository<Kinship, Integer> {

    @Override
    Optional<Kinship> findById(Integer integer);
}
