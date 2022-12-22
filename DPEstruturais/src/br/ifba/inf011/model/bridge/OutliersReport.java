package br.ifba.inf011.model.bridge;

import java.util.Set;

import br.ifba.inf011.model.AmbienteNTermometros;

public class OutliersReport extends AbstractReport{
	
	private double min;
	private double max;
	
	public OutliersReport(Medium meio, AmbienteNTermometros ambiente, double min, double max) {
		super(meio, ambiente);
		this.min = min;
		this.max = max;
	}


	public void makeHeader() throws Exception{
		super.makeHeader();
		System.out.println("Relatorio de Outliers");
		
	}


	public void makeDetail() throws Exception {
		for(int i = 0; i < 100; i++) {
			Set<String> ids = this.ambiente.getIds();
			for(String s : ids) {
				Double temperatura = ambiente.getTemperatura(s);
				if(temperatura < min || temperatura > max)
					this.medium.write(i + " - " + "[" + s + "] " + ":" + temperatura);
			}	
		}	
	}


	public void makeFooter() throws Exception{
		this.medium.write("END--REPORT");
		super.makeFooter();
	}

}
