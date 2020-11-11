package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum BeneficiosCadastrados {

    BENEFICIO_DE_PRESTAÇÃO_CONTINUADA,
    BOLSA_FAMÍLIA,
    CRÉDITO_SOCIAL,
    OUTROS;

    public static BeneficiosCadastrados getBeneficiosCadastradosCode(int opcao) {
        if (opcao == 1) {
            return BENEFICIO_DE_PRESTAÇÃO_CONTINUADA;
        } else if (opcao == 2) {
            return BOLSA_FAMÍLIA;
        } else if (opcao == 3) {
            return CRÉDITO_SOCIAL;
        } else if (opcao == 4) {
            return OUTROS;
        } else {
            throw new RegraNegocioException("Campo de Benefícios Cadastrados é inválido");
        }
    }

}
