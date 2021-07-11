package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestaCorrecaoCalcio {

	@Test
	void testaCalcParticipacaoAtualCTCSolo() {
		var correcaoCalcio = new CorrecaoCalcioMagnesio();
		var atualCTCSolo = correcaoCalcio.calcParticipacaoAtualCTCSolo(0.15, 5.76, 1.63, 5.35);
		assertEquals(44.68, atualCTCSolo, 0.01);
	}
}
