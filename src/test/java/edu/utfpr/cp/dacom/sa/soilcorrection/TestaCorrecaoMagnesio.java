package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestaCorrecaoMagnesio {

	@Test
	void testaCalcParticipacaoAtualCTCSolo() {
		var correcaoMagnesio = new CorrecaoMagnesio();
		var atualCTCSolo = correcaoMagnesio.calcParticipacaoAtualCTCSolo(0.15, 5.76, 1.63, 5.35);
		assertEquals(12.64, atualCTCSolo, 0.01);
	}
}
