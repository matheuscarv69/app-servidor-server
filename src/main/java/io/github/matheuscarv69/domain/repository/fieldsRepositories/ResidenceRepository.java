package io.github.matheuscarv69.domain.repository.fieldsRepositories;

import io.github.matheuscarv69.domain.entity.fields.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidenceRepository extends JpaRepository<Residence, Integer> {

    @Override
    Optional<Residence> findById(Integer integer);
}
