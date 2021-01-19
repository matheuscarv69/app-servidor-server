package io.github.matheuscarv69.domain.entity.fields;

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
public class Schooling {

    @Id
    private Integer id;

    @Column(length = 40)
    private String schooling;

}
