package io.github.matheuscarv69.rest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormSocialDTO {

    private String nome;

    private int idade;

    private String telefone;

    private String email;

    private String funcaoExerc;

    private String tempoFuncaoExerc;

    private String estadoCivil;

}
