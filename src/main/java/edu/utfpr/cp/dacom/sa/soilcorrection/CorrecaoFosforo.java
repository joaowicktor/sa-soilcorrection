package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoFosforo implements ICorrecaoNutriente<FonteFosforo> {
    public double calcNecessidadeFosforoAAdicionar(double teorFosforoAtingir, double valorFosforo) {
    	var necessidadeFosforoAdicionar = teorFosforoAtingir - valorFosforo;
		return necessidadeFosforoAdicionar < 0.01 ? 0.0 : necessidadeFosforoAdicionar;
    }
}
