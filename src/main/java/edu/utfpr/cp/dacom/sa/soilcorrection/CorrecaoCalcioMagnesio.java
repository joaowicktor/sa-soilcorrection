package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {
	
	public double calcParticipacaoAtualCalcioCTCSolo(double valorPotassio, double valorCalcio, double valorMagnesio, double acidezPotencial) {
		double ctcCmol = new EquilibrioCorrecaoCTC().calculaCTCCmol(valorPotassio, valorCalcio, valorMagnesio, acidezPotencial);
		
		if (ctcCmol <= 0 || valorCalcio <= 0) {
			throw new IllegalArgumentException();
		}
		
		return valorCalcio / ctcCmol * 100;
	}
	
	public double calcParticipacaoAtualMagnesioCTCSolo(double valorPotassio, double valorCalcio, double valorMagnesio, double acidezPotencial) {
		double ctcCmol = new EquilibrioCorrecaoCTC().calculaCTCCmol(valorPotassio, valorCalcio, valorMagnesio, acidezPotencial);
		
		if (ctcCmol <= 0 || valorMagnesio <= 0) {
			throw new IllegalArgumentException();
		}
		
		return valorMagnesio / ctcCmol * 100;
	}
	
	public String participacaoIdealCalcioCTCSolo(TexturaSolo texturaSolo) {
		switch (texturaSolo) {
			case ARGILOSO: return "45 a 55";
			case TEXTURA_MEDIA: return "35 a 40";
			default: return "";
		}
	}
	
	public String participacaoIdealMagnesioCTCSolo(TexturaSolo texturaSolo) {
		switch (texturaSolo) {
			case ARGILOSO: return "10 a 15";
			case TEXTURA_MEDIA: return "8 a 12";
			default: return "";
		}
	}
	
	public double calcQtdCaOAdicionadoFosfatagem(FonteFosforo fonteFosforo) {
		switch (fonteFosforo) {
			case SUPERFOSFATO_SIMPLES: return 0.49924;
			case SUPERFOSFATO_TRIPLO: return 0.33877;
			case MAP: return 0.0;
			case DAP: return 0.0;
			case TERMOFOSFATO_YOORIN: return 0.49924;
			case FOSFATO_REATIVO_ARAD: return 0.92716;
			case FOSFATO_REATIVO_GAFSA: return 0.92716;
			case FOSFATO_REATIVO_DAOUI: return 0.80235;
			case FOSFATO_PATOS_DE_MINAS: return 0.795218;
			case ESCORIA_DE_THOMAS: return 0.49924;
			case ACIDO_FOSFORICO: return 0.0;
			case MULTIFOSFATO_MAGNESIANO: return 0.0;
			default: return 0.0;
		}
	}
	
	public double calcQtdCaOAdicionadoFosfatagemPorHectare(FonteFosforo fonteFosforo, double teorFosforoAtingir, double valorFosforo, double eficienciaFosforo) {
		var correcaoFosforo = new CorrecaoFosforo();
		var P2O5 = new ConverteKgHaEmP2O5().converte(correcaoFosforo.calcNecessidadeFosforoAAdicionar(teorFosforoAtingir, valorFosforo) * 2);
		var H16 = P2O5 * 100 / eficienciaFosforo / 100;
		double B22 = H16 * 100 / (fonteFosforo.getTeorFonte());
		double B24 = B22 * 2.42;
		double M22;
		
		switch (fonteFosforo) {
			case SUPERFOSFATO_SIMPLES: M22 = B24 * 0.28; break;
			case SUPERFOSFATO_TRIPLO: M22 = B24 * 0.2; break;
			case MAP: M22 = B24 * 0.09; break;
			case DAP: M22 = B24 * 0.16; break;
			case TERMOFOSFATO_YOORIN: M22 = B24 * 0.28; break;
			case FOSFATO_REATIVO_ARAD: M22 = B24 * 0.52; break;
			case FOSFATO_REATIVO_GAFSA: M22 = B24 * 0.52; break;
			case FOSFATO_REATIVO_DAOUI: M22 = B24 * 0.45; break;
			case FOSFATO_PATOS_DE_MINAS: M22 = B24 * 0.28; break;
			case ESCORIA_DE_THOMAS: M22 = B24 * 0.44; break;
			case ACIDO_FOSFORICO: M22 = B24 * 0; break;
			case MULTIFOSFATO_MAGNESIANO: M22 = B24 * 0.18; break;
			default: M22 = B24 * 0;
		}
		return (M22/2.42) * this.calcQtdCaOAdicionadoFosfatagem(fonteFosforo) / 1000;
	}
	
	public double calcTeorCaOaAdicionar(
		double valorCalcio, 
		double participacaoDeCalcioNaCTCDesejada, 
		double participacaoAtualDeCalcioNaCTC,
		double qtdCaOFosfatagem
	) {
		return (valorCalcio * participacaoDeCalcioNaCTCDesejada / participacaoAtualDeCalcioNaCTC) - valorCalcio - qtdCaOFosfatagem;
	}
	
	public double calcQuantidadeCorretivo(double qtdeCaOAdicionadaFosfatagem, double teorCaOAdicionar, double teorCaOCorretivo) {
		var qtdeCalcioAdicionadaTotal = (teorCaOCorretivo * 0.01783) + qtdeCaOAdicionadaFosfatagem;
		
		return teorCaOAdicionar / qtdeCalcioAdicionadaTotal;
	}

	public double calcQuantidadeAplicarPorHectare(double qtdeCorretivo, double prnt) {

        if (qtdeCorretivo <= 0 || prnt <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeCorretivo * 100 / prnt;
    }
	
	public double calcQuantidadeAplicarPorAlqueire(double qtdeAplicarPorHectare) {

        if (qtdeAplicarPorHectare <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeAplicarPorHectare * 2.42;
    }
	
	@Override
	public double calculaCusto(double custoFonte, double qtdeAplicar) {
		if (custoFonte <= 0) {
            throw new IllegalArgumentException();
        }

        if (qtdeAplicar <= 0) {
            throw new IllegalArgumentException();
        }

        return custoFonte * qtdeAplicar / 2.42;
	}
}
