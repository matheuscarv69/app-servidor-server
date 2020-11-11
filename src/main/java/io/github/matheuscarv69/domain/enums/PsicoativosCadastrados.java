package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum PsicoativosCadastrados {

    ÁLCOOL,
    CIGARRO,
    DROGAS_ILÍCITAS,
    OUTROS;

    public static PsicoativosCadastrados getPsicoativosCode(int opcao) {
        if (opcao == 1) {
            return ÁLCOOL;
        } else if (opcao == 2) {
            return CIGARRO;
        } else if (opcao == 3) {
            return DROGAS_ILÍCITAS;
        } else if (opcao == 4) {
            return OUTROS;
        } else {
            throw new RegraNegocioException("Campo Psicoativos Cadastrados é inválido");
        }
    }
}


