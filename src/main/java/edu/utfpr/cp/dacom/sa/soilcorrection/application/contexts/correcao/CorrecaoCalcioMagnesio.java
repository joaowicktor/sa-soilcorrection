package edu.utfpr.cp.dacom.sa.soilcorrection.application.contexts.correcao;

import edu.utfpr.cp.dacom.sa.soilcorrection.domain.enums.FonteCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrection.domain.interfaces.ICorrecaoNutriente;

public class CorrecaoCalcioMagnesio 
        implements ICorrecaoNutriente<FonteCalcioMagnesio> {

    public double calculaQuantidadeAplicar(
        double qtdeFonteAdicionar, 
        double prntPercent) {

        if (qtdeFonteAdicionar <= 0) {
            throw new IllegalArgumentException();
        }

        if (prntPercent <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeFonteAdicionar / prntPercent;
    }
}
