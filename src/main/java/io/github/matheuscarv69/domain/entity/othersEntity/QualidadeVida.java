package io.github.matheuscarv69.domain.entity.othersEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "form")
public class QualidadeVida {

    @Id
    private Integer id;

    @Column(name = "qualidade_vida", length = 30)
    private String qualidadeVida;
}
