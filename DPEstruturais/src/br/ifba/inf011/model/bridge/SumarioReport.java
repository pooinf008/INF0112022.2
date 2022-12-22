package br.ifba.inf011.model.bridge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import br.ifba.inf011.model.AmbienteNTermometros;

public class SumarioReport extends AbstractReport{
	
	public SumarioReport(Medium meio, AmbienteNTermometros ambiente) {
		super(meio, ambiente);
	}


	public void makeHeader() throws Exception{
		super.makeHeader();
		System.out.println("Relatorio de Temperaturas");
		
	}


	public void makeDetail() throws Exception {
		HashMap<String, SummaryElemento> temps = new HashMap<String, SummaryElemento>();
		
		Set<String> ids = this.ambiente.getIds();
		
		for(int i = 0; i < 100; i++) {
			for(String s : ids) {
				Double temperatura = ambiente.getTemperatura(s);
				SummaryElemento elemento = temps.get(s);
				if(elemento == null) {
					elemento = new SummaryElemento(s);
				}
				elemento.add(temperatura);
				temps.put(s, elemento);
			}	
		}
		
		for(String s : ids) {
			SummaryElemento elemento = temps.get(s);
			this.medium.write("[" + s + "] " + ":" + elemento.mean());
		}
	}


	public void makeFooter() throws Exception{
		this.medium.write("END--REPORT");
		super.makeFooter();
	}
	
	
	

}
