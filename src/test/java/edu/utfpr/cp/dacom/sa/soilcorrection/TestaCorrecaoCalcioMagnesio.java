package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestaCorrecaoCalcioMagnesio {

	@Test
	void testaCalcParticipacaoAtualCalcioCTCSolo() {
		var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
		var atualCTCSolo = correcaoCalcioMagnesio.calcParticipacaoAtualCalcioCTCSolo(0.15, 5.76, 1.63, 5.35);
		assertEquals(44.68, atualCTCSolo, 0.01);
	}
	
	@Test
	void testaCalcParticipacaoAtualMagnesioCTCSolo() {
		var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
		var atualCTCSolo = correcaoCalcioMagnesio.calcParticipacaoAtualMagnesioCTCSolo(0.15, 5.76, 1.63, 5.35);
		assertEquals(12.64, atualCTCSolo, 0.01);
	}
	
	@Test
	void testaCalcQtdCaOAdicionadoFosfatagemPorHectare() {
		var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
		var qtdCaOFosfatagem = correcaoCalcioMagnesio.calcQtdCaOAdicionadoFosfatagemPorHectare(FonteFosforo.SUPERFOSFATO_SIMPLES, 12, 8.59, 70);
		assertEquals(0.0173, qtdCaOFosfatagem, 0.01);
	}
	
	@Test
	void testaCalcTeorCaOaAdicionar() {
		var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
		var teorCaO = correcaoCalcioMagnesio.calcTeorCaOaAdicionar(5.76, 55.0, 44.6858, 0.0173);
		assertEquals(1.3122, teorCaO, 0.01);
	}
	
	@Test
	void testaCalcQuantidadeCorretivo() {
		var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
		var teorCaOCorretivo = FonteCalcioMagnesio.CALCARIO_CALCITICO.getTeorCaOCorretivo(0);
		var qtdeCorretivo = correcaoCalcioMagnesio.calcQuantidadeCorretivo(0.0173, 1.3122, teorCaOCorretivo);
		assertEquals(1.29175484, qtdeCorretivo, 0.01);
	}
	
	@Test
	void testaQuantidadeAplicarPorHectare() {
        var qtdeCorretivo = 1.29175484;
        var prnt = 70;

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
        var qtdePorHectare = correcaoCalcioMagnesio.calcQuantidadeAplicarPorHectare(qtdeCorretivo, prnt);
        
        assertEquals(1.845364057, qtdePorHectare, 0.01);
    }
	
	@Test
	void testaQuantidadeAplicarPorAlqueire() {
        var qtdePorHectare = 1.845364057;

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
        var qtdePorAlqueire = correcaoCalcioMagnesio.calcQuantidadeAplicarPorAlqueire(qtdePorHectare);

        assertEquals(4.465781018, qtdePorAlqueire, 0.01);
    }
	
	@Test
	void testaCustoReaisHa() {
		var qtdeCalcioMagnesioAplicar = 4.465781018;
		        
		var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
		var custo = correcaoCalcioMagnesio.calculaCusto(500.0, qtdeCalcioMagnesioAplicar);
        
        assertEquals(922.68, custo, 0.01);
	}
}
