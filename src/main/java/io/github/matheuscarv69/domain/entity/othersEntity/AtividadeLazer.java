package io.github.matheuscarv69.domain.entity.othersEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.matheuscarv69.domain.entity.FormSocial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "form")
public class AtividadeLazer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String atividadeLazer;

    @JsonIgnore
    @ManyToMany(mappedBy = "atividadesLazer")
    private List<FormSocial> form;

}
