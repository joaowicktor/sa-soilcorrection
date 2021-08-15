package edu.utfpr.cp.dacom.sa.soilcorrection.domain.entities;

import edu.utfpr.cp.dacom.sa.soilcorrection.domain.enums.NomeNutrienteAdicional;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class NutrienteAdicional {
    @NonNull private final NomeNutrienteAdicional nome;
    private final double teorNutriente;
    
    @Setter private double correcaoAdicional; 
}
