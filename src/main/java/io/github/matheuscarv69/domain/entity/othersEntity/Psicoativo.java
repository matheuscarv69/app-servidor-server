package io.github.matheuscarv69.domain.entity.othersEntity;

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
public class Psicoativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String psicoativo;

    @JsonIgnore
    @ManyToMany(mappedBy = "psicoativos")
    private List<FormSocial> form = new ArrayList<>();
}
