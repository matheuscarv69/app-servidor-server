package io.github.matheuscarv69.domain.repository.fieldsRepositories;

import io.github.matheuscarv69.domain.entity.fields.StateCivil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateCivilRepository extends JpaRepository<StateCivil, Integer> {

    @Override
    Optional<StateCivil> findById(Integer integer);

}
