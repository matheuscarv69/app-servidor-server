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
public class Vacina {

    @Id
    private Integer id;

    @Column(length = 20)
    private String vacina;

}
