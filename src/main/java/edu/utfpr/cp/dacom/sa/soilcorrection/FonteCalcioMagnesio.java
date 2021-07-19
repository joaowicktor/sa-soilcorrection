package edu.utfpr.cp.dacom.sa.soilcorrection;

import java.util.Set;

public enum FonteCalcioMagnesio implements IFonteNutriente {
	CALCARIO_DOLOMITICO(0.304, Set.of()),
	CALCARIO_CALCITICO(0.56, Set.of()),
	CALCARIO_DE_CONCHA(0.54, Set.of()),
	GESSO_AGRICOLA(0.29, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.ENXOFRE, 1.5))),
	HIDROXIDO_DE_CALCIO(0.757, Set.of()),
	CALCARIO_MAGNESIANO(0.35, Set.of());

	private final double teorFonte;
	private final Set<NutrienteAdicional> nutrientesAdicionais;
	
	FonteCalcioMagnesio(double teorFonte, final Set<NutrienteAdicional> nutrientesAdicionais) {
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
	
	public double getTeorCaOCorretivo(double teorCaOCorretivo) {
		if (teorCaOCorretivo > 0.01) {
			return teorCaOCorretivo;
		}
		
		switch (this) {
			case CALCARIO_DOLOMITICO: return 30.4;
			case CALCARIO_CALCITICO: return 56;
			case CALCARIO_DE_CONCHA: return 54;
			case GESSO_AGRICOLA: return 29;
			case HIDROXIDO_DE_CALCIO: return 75.7;
			case CALCARIO_MAGNESIANO: return 35;
			default: return 0.0;
		}
	}
}
