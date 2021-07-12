package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

public enum FonteFosforo implements IFonteNutriente {
    SUPERFOSFATO_SIMPLES(0.18, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.ENXOFRE, 0.1), new NutrienteAdicional(NomeNutrienteAdicional.CALCIO, 0.28))),
    SUPERFOSFATO_TRIPO(0.41, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.CALCIO, 0.2))),
    MAP(0.48, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.CALCIO, 0.09))),
    DAP(0.45, Set.of()),
    TERMOFOSFATO_YOORIN(0.18, Set.of()),
    FOSFATO_REATIVO_ARAD(0.33, Set.of()),
    FOSFATO_REATIVO_GAFSA(0.29, Set.of()),
    FOSFATO_REATIVO_DAOUI(0.32, Set.of()),
    FOSFATO_PATOS_DE_MINAS(0.24, Set.of()),
    ESCORIA_DE_THOMAS(0.185, Set.of()),
    ACIDO_FOSFORICO(0.52, Set.of()),
    MULTIFOSFATO_MAGNESIANO(0.18, Set.of());

    private final double teorFonte;
    private final Set<NutrienteAdicional> nutrientesAdicionais;

    FonteFosforo(
        double teorFonte,
        final Set<NutrienteAdicional> nutrientesAdicionais) {

        this.teorFonte = teorFonte;
        this.nutrientesAdicionais = nutrientesAdicionais;
    }

    @Override
    public double getTeorFonte() {
        return this.teorFonte;
    }

    @Override
    public Set<NutrienteAdicional> getNutrientesAdicionais() {
        return this.nutrientesAdicionais;
    }
}
