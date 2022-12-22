package br.ifba.edu.aval1.model;

public abstract class Repeticao extends Controle{

	protected Comando comando;
	
	public Repeticao() {
		super();
		this.comando = null;
	}
	
	public Repeticao(ComandoSimples condicao, Comando comando) {
		super(condicao);
		this.addComando(comando);
	}
	
	public void addComando(Comando comando) {
		this.comando = comando;
	}
	
}
