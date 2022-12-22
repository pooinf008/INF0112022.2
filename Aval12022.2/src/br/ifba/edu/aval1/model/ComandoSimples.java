package br.ifba.edu.aval1.model;

public abstract class ComandoSimples implements Comando{
	
	protected String valor;

	public ComandoSimples(String valor) {
		this.setValor(valor);
	}
	
	
	public abstract String getValor();

	private void setValor(String valor) {
		this.valor = valor;
	}
	
	
	

}
