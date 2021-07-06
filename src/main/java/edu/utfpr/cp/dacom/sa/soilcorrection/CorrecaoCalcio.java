package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcio implements ICorrecaoNutriente<FonteCalcio> {
	
	public double calcParticipacaoAtualCTCSolo(double valorPotassio, double valorCalcio, double valorMagnesio, double acidezPotencial) {
		double ctcCmol = new EquilibrioCorrecaoCTC().calculaCTCCmol(valorPotassio, valorCalcio, valorMagnesio, acidezPotencial);
		
		if (ctcCmol <= 0 || valorCalcio <= 0) {
			throw new IllegalArgumentException();
		}
		
		return valorCalcio / ctcCmol * 100;
	}
	
	public String participacaoIdealCTCSolo(TexturaSolo texturaSolo) {
		switch (texturaSolo) {
			case ARGILOSO: return "45 a 55";
			case TEXTURA_MEDIA: return "35 a 40";
			default: return "";
		}
	}
}
