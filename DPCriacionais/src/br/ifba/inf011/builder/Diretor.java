package br.ifba.inf011.builder;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.criacional.fm.model.atuadores.Estabilizador;
import br.ifba.inf011.criacional.fm.model.atuadores.Resfriador;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroAlta;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroFaixa;

public class Diretor {
	
	public Construtor construtor;
	
	public Diretor(Construtor construtor) {
		this.construtor = construtor;
	}
	
	public void makeControladorAltaPadrao() {
		this.construtor.reset();
		this.construtor.withTermometro(new TermometroAlta());
		this.construtor.withAtuador(new Resfriador());
		this.construtor.setTemperaturaMaxima(30);
		this.construtor.setSaidaAlarme(System.out);
		this.construtor.setSaidaPadrao(System.out);
	}

	public void makeControladorFaixaPadrao(Ambiente ambiente) {
		this.construtor.reset();
		this.construtor.withTermometro(new TermometroFaixa());
		this.construtor.withAtuador(new Estabilizador());
		this.construtor.setTemperaturaMinima(25);
		this.construtor.setTemperaturaMaxima(30);
		this.construtor.setSaidaAlarme(System.err);
		this.construtor.setSaidaPadrao(System.err);
		this.construtor.monitorar(ambiente);
	}

	public void setConstrutor(Construtor construtor) {
		this.construtor = construtor;
	}	
	
}
