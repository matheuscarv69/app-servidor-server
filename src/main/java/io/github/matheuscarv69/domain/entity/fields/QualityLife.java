package io.github.matheuscarv69.domain.entity.fields;

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
public class QualityLife {

    @Id
    private Integer id;

    @Column(name = "quality_life", length = 30)
    private String qualityLife;
}
