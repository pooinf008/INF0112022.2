package br.ifba.edu.aval1.model;

public abstract class Controle implements Comando{
	
	protected ComandoSimples condicao;
	
	public Controle() {
		this.condicao = null;
	}
	
	public Controle(ComandoSimples condicao) {
		this.setCondicao(condicao);
	}

	public ComandoSimples getCondicao() {
		return condicao;
	}

	private void setCondicao(ComandoSimples condicao) {
		this.condicao = condicao;
	}
	
	public abstract String getValor();
	
	

}
