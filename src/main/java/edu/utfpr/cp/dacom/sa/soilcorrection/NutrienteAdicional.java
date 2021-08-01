package edu.utfpr.cp.dacom.sa.soilcorrection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class NutrienteAdicional {
    private final NomeNutrienteAdicional nome;
    private final double teorNutriente;
    @Setter private double correcaoAdicional; 
}
