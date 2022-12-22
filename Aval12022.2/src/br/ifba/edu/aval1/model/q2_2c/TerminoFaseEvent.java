package br.ifba.edu.aval1.model.q2_2c;

import br.ifba.edu.aval1.model.Lang;

public class TerminoFaseEvent {
	
	private String faseConcluida;
	private boolean sucesso; 
	private Lang lang;
	
	
	public TerminoFaseEvent(Lang lang, String faseConcluida, boolean sucesso) {
		this.lang = lang;
		this.faseConcluida = faseConcluida;
		this.sucesso = sucesso;
	}
	
	public TerminoFaseEvent(Lang lang, String faseConcluida) {
		this(lang, faseConcluida, true);
	}	
	
	public String toString() {
		return "Término da " + this.faseConcluida  + " – " + this.lang;
	}

}
