package io.github.matheuscarv69.domain.enums;

public enum AtividadeLazer {
    NAO(1),
    MANUAIS(2),
    SOCIAIS(3),
    FISICAS_ESPORTIVAS(4),
    CULTURAIS(5),
    OUTRAS(6);

    private final int atividadeLazerCode;

    AtividadeLazer(int atividadeLazerCode) {
        this.atividadeLazerCode = atividadeLazerCode;
    }
}
