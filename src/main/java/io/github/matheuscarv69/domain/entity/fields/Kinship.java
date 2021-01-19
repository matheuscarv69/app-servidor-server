package io.github.matheuscarv69.domain.entity.fields;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.matheuscarv69.domain.entity.FormSocial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "form")
public class Kinship {

    @Id
    private Integer id;

    @Column(length = 30)
    private String kinship;

    @JsonIgnore
    @ManyToMany(mappedBy = "kinships")
    private List<FormSocial> forms = new ArrayList<>() ;


}
