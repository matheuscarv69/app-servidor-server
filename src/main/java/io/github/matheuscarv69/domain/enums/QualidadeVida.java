package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum QualidadeVida {

    EXCELENTE,
    BOA,
    REGULAR,
    RUIM;

    public static QualidadeVida getQualidadeVIdaCode(int opcao) {
        if (opcao == 1) {
            return EXCELENTE;
        } else if (opcao == 2) {
            return BOA;
        } else if (opcao == 3) {
            return REGULAR;
        } else if(opcao == 4){
            return RUIM;
        } else {
            throw new RegraNegocioException("Campo Qualidade Vida é inválido");
        }
    }


}
