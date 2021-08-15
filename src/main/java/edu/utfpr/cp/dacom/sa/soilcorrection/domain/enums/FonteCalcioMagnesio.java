package edu.utfpr.cp.dacom.sa.soilcorrection.domain.enums;

import java.util.Set;

import edu.utfpr.cp.dacom.sa.soilcorrection.domain.entities.NutrienteAdicional;
import edu.utfpr.cp.dacom.sa.soilcorrection.domain.interfaces.IFonteNutriente;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FonteCalcioMagnesio implements IFonteNutriente {
    CALCARIO_DOLOMITICO(30.4, Set.of()),
    CALCARIO_CALCITICO(56.0, Set.of()),
    CALCARIO_CONCHA(54.0, Set.of()),
    GESSO_AGRICOLA(29.0, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.ENXOFRE, 0.15))),
    HIDROXIDO_CALCIO(75.7, Set.of()),
    CALCARIO_MAGNESIANO(35.0, Set.of());
	
    private final double teorFonte;
	@NonNull private final Set<NutrienteAdicional> nutrientesAdicionais;	
}
