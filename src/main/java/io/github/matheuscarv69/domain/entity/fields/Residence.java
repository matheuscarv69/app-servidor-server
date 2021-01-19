package io.github.matheuscarv69.domain.entity.fields;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "form")
public class Residence {

    @Id
    private Integer id;

    @Column(length = 30)
    private String residence;


}
