package edu.utfpr.cp.dacom.sa.soilcorrection.domain.interfaces;

import java.util.Set;

import edu.utfpr.cp.dacom.sa.soilcorrection.domain.entities.NutrienteAdicional;

public interface IFonteNutriente {
    
    public double getTeorFonte();
    public Set<NutrienteAdicional> getNutrientesAdicionais();
}
