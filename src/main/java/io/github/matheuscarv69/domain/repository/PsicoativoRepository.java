package io.github.matheuscarv69.domain.repository;


import io.github.matheuscarv69.domain.entity.othersEntity.Psicoativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsicoativoRepository extends JpaRepository<Psicoativo, Integer> {

    @Override
    Optional<Psicoativo> findById(Integer integer);

}
