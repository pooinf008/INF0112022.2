package br.ifba.inf011.model.bridge;

import br.ifba.inf011.model.AmbienteNTermometros;

public abstract class AbstractReport {

	protected AmbienteNTermometros ambiente;
	protected Medium medium;
	
	public AbstractReport(Medium meio, AmbienteNTermometros ambiente) {
		this.ambiente = ambiente;
		this.medium = meio;
	}
	
	
	public void doReport() throws Exception{
		this.makeHeader();
		this.makeDetail();
		this.makeFooter();
	}


	public void makeHeader() throws Exception{
		this.medium.prepare();
	};
	
	public abstract void makeDetail()throws Exception; 
	
	public void makeFooter() throws Exception{
		this.medium.close();
	};	
	
	
}
