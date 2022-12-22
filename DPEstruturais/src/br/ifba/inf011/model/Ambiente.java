package br.ifba.inf011.model;

public class Ambiente {
	
	private Termometro termometro;
	
	public Ambiente(Termometro termometro) {
		this.termometro = termometro;
	}
	
	public String toString() {
		return "Ambiente\n" + this.termometro.toTab(0);
	}
	
	public Termometro getTermometro() {
		return this.termometro;
	}

	public void atualizarFirmware(String version) {
		this.termometro.atualizarFirmware(version);
	}

}
