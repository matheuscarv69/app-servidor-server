package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum DoencasCronicasCadastradas {

    CANCÊR,
    DIABETES,
    DEPRESSÃO,
    HIPERTENSÃO,
    OUTRAS;

    public static DoencasCronicasCadastradas getDoencaCronicaCode(int opcao) {
        if (opcao == 1) {
            return CANCÊR;
        } else if (opcao == 2) {
            return DIABETES;
        } else if (opcao == 3) {
            return DEPRESSÃO;
        } else if (opcao == 4) {
            return HIPERTENSÃO;
        } else if (opcao == 5) {
            return OUTRAS;
        } else {
            throw new RegraNegocioException("Campo Doenças Crônicas Cadastradas inválido");
        }
    }
}


