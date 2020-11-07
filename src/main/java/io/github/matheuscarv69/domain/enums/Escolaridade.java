package io.github.matheuscarv69.domain.enums;

public enum Escolaridade {

    ANALFABETO(1),
    ENSINO_FUNDAMENTAL_INCOMPLETO(2),
    ENSINO_FUNDAMENTAL_COMPLETO(3),
    ENSINO_MEDIO_INCOMPLETO(4),
    ENSINO_MEDIO_COMPLETO(5),
    ENSINO_SUPERIOR_INCOMPLETO(6),
    ENSINO_SUPERIOR_COMPLETO(7);

    private final int escolaridadeCode;

    Escolaridade(int escolaridadeCode) {
        this.escolaridadeCode = escolaridadeCode;
    }
}
