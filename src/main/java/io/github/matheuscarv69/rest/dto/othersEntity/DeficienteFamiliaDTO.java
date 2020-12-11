package io.github.matheuscarv69.rest.dto.othersEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeficienteFamiliaDTO {

    private String pessoa;
    private String deficiencia;


}
