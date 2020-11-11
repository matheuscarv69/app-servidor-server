package io.github.matheuscarv69.domain.enums;

import io.github.matheuscarv69.exceptions.RegraNegocioException;

public enum ProgramasSociaisCadastrados {

    JOVEM_APRENDIZ,
    PROGRAMA_DA_PREFEITURA,
    CREA_CRAS,
    CAPS_I_II_III_E_AD,
    OUTROS;

    public static ProgramasSociaisCadastrados getProgramasSociaisCadCode(int opcao) {
        if (opcao == 1) {
            return JOVEM_APRENDIZ;
        } else if (opcao == 2) {
            return PROGRAMA_DA_PREFEITURA;
        } else if (opcao == 3) {
            return CREA_CRAS;
        } else if (opcao == 4) {
            return CAPS_I_II_III_E_AD;
        } else if (opcao == 5) {
            return OUTROS;
        } else {
            throw new RegraNegocioException("Campo de Programas Sociais Cadastrados é inválido");
        }
    }

}
