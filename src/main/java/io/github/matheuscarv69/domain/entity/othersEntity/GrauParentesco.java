package io.github.matheuscarv69.domain.entity.othersEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.matheuscarv69.domain.entity.FormSocial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "form")
public class GrauParentesco {

    @Id
    private Integer id;

    @Column(length = 30)
    private String grauParentesco;

    @JsonIgnore
    @ManyToMany(mappedBy = "grauParentescos")
    private List<FormSocial> forms = new ArrayList<>() ;
}
