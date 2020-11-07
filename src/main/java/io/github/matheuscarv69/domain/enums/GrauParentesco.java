package io.github.matheuscarv69.domain.enums;

public enum GrauParentesco {
    ESPOSO_A(1),
    PAI(2),
    MAE(3),
    AVOS(4),
    FILHOS_AS(5),
    IRMAO_A(6),
    TIO_A(7),
    SOBRINHO_A(8),
    PRIMO_A(9),
    SOGRO_A(10),
    ENTEADO_A(11),
    OUTROS(12);

    private final int grauParentescoCode;

    GrauParentesco(int grauParentescoCode) {
        this.grauParentescoCode = grauParentescoCode;
    }
}
