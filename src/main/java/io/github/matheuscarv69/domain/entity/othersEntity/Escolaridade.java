package io.github.matheuscarv69.domain.entity.othersEntity;

import io.github.matheuscarv69.domain.entity.FormSocial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "form")
public class Escolaridade {

    @Id
    private Integer id;

    @Column(name = "escolaridade", length = 40)
    private String escolaridade;

}
