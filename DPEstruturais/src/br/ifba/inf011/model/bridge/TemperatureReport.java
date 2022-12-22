package br.ifba.inf011.model.bridge;

import java.util.Set;

import br.ifba.inf011.model.AmbienteNTermometros;

public class TemperatureReport extends AbstractReport{
	
	public TemperatureReport(Medium meio, AmbienteNTermometros ambiente) {
		super(meio, ambiente);
	}


	public void makeHeader() throws Exception{
		super.makeHeader();
		System.out.println("Relatorio de Temperaturas");
		
	}


	public void makeDetail() throws Exception {
		for(int i = 0; i < 100; i++) {
			Set<String> ids = this.ambiente.getIds();
			for(String s : ids) {
				Double temperatura = ambiente.getTemperatura(s);
				this.medium.write(i + " - " + "[" + s + "] " + ":" + temperatura);
			}	
		}	
	}


	public void makeFooter() throws Exception{
		this.medium.write("END--REPORT");
		super.makeFooter();
	}
	
	
	

}
