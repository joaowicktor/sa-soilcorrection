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
}
