package edu.utfpr.cp.dacom.sa.soilcorrection.application.contexts.correcao;

import edu.utfpr.cp.dacom.sa.soilcorrection.domain.enums.FonteFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrection.domain.interfaces.ICorrecaoNutriente;
import edu.utfpr.cp.dacom.sa.soilcorrection.domain.interfaces.ICorrecaoNutrienteQuantidadeAplicar;

public class CorrecaoFosforo 
    implements 
        ICorrecaoNutriente<FonteFosforo>,
        ICorrecaoNutrienteQuantidadeAplicar<FonteFosforo> {
    
}
