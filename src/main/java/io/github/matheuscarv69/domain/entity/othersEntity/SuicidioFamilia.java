package io.github.matheuscarv69.domain.entity.othersEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "form")
public class SuicidioFamilia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String suicidio;

    @OneToOne
    @JoinColumn(name = "grau_parentesco_id")
    private GrauParentesco grauParentescoSuicidio;


}
