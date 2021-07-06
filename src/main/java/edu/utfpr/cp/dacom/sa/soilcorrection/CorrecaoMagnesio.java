package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoMagnesio implements ICorrecaoNutriente<FonteMagnesio> {
	
	public double calcParticipacaoAtualCTCSolo(double valorPotassio, double valorCalcio, double valorMagnesio, double acidezPotencial) {
		double ctcCmol = new EquilibrioCorrecaoCTC().calculaCTCCmol(valorPotassio, valorCalcio, valorMagnesio, acidezPotencial);
		
		if (ctcCmol <= 0 || valorMagnesio <= 0) {
			throw new IllegalArgumentException();
		}
		
		return valorMagnesio / ctcCmol * 100;
	}
}
