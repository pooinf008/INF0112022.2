package br.ifba.edu.aval1.model;

public abstract class Selecao extends Controle{

	protected Comando comandoPositivo;
	protected Comando comandoNegativo;
	
	public Selecao(ComandoSimples condicao, Comando comandoPositivo) {
		this(condicao, comandoPositivo, null);
	}
	
	public Selecao(ComandoSimples condicao, Comando comandoPositivo, 
				   Comando comandoNegativo) {
		super(condicao);
		this.setComandoPositivo(comandoPositivo);
		this.setComandoNegativo(comandoNegativo);
	}
	
	private void setComandoNegativo(Comando comandoNegativo) {
		this.comandoNegativo = comandoNegativo;
	}

	private void setComandoPositivo(Comando comandoPositivo) {
		this.comandoPositivo = comandoPositivo;
	}
	

}