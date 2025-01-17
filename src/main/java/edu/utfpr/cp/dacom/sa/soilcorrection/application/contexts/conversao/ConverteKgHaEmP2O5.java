package edu.utfpr.cp.dacom.sa.soilcorrection.application.contexts.conversao;

import edu.utfpr.cp.dacom.sa.soilcorrection.domain.interfaces.Conversao;

public class ConverteKgHaEmP2O5 implements Conversao<Double, Double> {

    @Override
    public Double converte(Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException();
        }

        return valor * 2.29;
    }
}
