package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {
	
	public double calcParticipacaoAtualCalcioCTCSolo(double valorPotassio, double valorCalcio, double valorMagnesio, double acidezPotencial) {
		double ctcCmol = new EquilibrioCorrecaoCTC().calculaCTCCmol(valorPotassio, valorCalcio, valorMagnesio, acidezPotencial);
		
		if (ctcCmol <= 0 || valorCalcio <= 0) {
			throw new IllegalArgumentException();
		}
		
		return valorCalcio / ctcCmol * 100;
	}
	
	public double calcParticipacaoAtualMagnesioCTCSolo(double valorPotassio, double valorCalcio, double valorMagnesio, double acidezPotencial) {
		double ctcCmol = new EquilibrioCorrecaoCTC().calculaCTCCmol(valorPotassio, valorCalcio, valorMagnesio, acidezPotencial);
		
		if (ctcCmol <= 0 || valorMagnesio <= 0) {
			throw new IllegalArgumentException();
		}
		
		return valorMagnesio / ctcCmol * 100;
	}
	
	public String participacaoIdealCalcioCTCSolo(TexturaSolo texturaSolo) {
		switch (texturaSolo) {
			case ARGILOSO: return "45 a 55";
			case TEXTURA_MEDIA: return "35 a 40";
			default: return "";
		}
	}
	
	public String participacaoIdealMagnesioCTCSolo(TexturaSolo texturaSolo) {
		switch (texturaSolo) {
			case ARGILOSO: return "10 a 15";
			case TEXTURA_MEDIA: return "8 a 12";
			default: return "";
		}
	}
}
