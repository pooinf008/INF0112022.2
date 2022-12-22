package br.ifba.inf011.model;

import br.ifba.inf011.model.bridge.AbstractReport;
import br.ifba.inf011.model.bridge.ConsoleMedium;
import br.ifba.inf011.model.bridge.FileMedium;
import br.ifba.inf011.model.bridge.OutliersReport;
import br.ifba.inf011.model.bridge.SumarioReport;
import br.ifba.inf011.model.bridge.TemperatureReport;
import br.ifba.inf011.model.decorator.CelsiusToFahrenheit;
import br.ifba.inf011.model.decorator.FahrenheitToKelvin;
import br.ifba.inf011.model.decorator.Sample5;
import br.ifba.inf011.model.proxy.AmbienteRemoto;
import br.ifba.inf011.model.proxy.ProxySeguranca;

public class App {

	private void run() {
		Ambiente ambiente = DataSource.getAmbiente01(27);
		System.out.println(ambiente);
		ambiente.atualizarFirmware("2.0");
		System.out.println(ambiente);
	}
	
	private void run2() {
		AmbienteNTermometros ambiente = DataSource.getAmbiente02(27);
		for(int i = 0; i < 50; i++) {
			Double temperatura = ambiente.getTemperatura("T" + ((i % 5) + 1));
			System.out.println(i + " - " + temperatura);
		}	
	}
	
	private void run3() {
		AmbienteNTermometros ambiente = new ProxySeguranca("root", "sysadmin");
		for(int i = 0; i < 50; i++) {
			Double temperatura = ambiente.getTemperatura("T" + ((i % 5) + 1));
			System.out.println(i + " - " + temperatura);
		}	
	}	
	
	private void run4() throws InterruptedException {
		AmbienteNTermometros ambiente = new AmbienteRemoto();
		for(int i = 0; i < 50; i++) {
			Double temperatura = ambiente.getTemperatura("T" + ((i % 5) + 1));
			System.out.println(i + " - " + temperatura);
			Thread.sleep(150);
		}	
	}	
	
	private void run5() throws InterruptedException {
		Termometro t1 = new FahrenheitToKelvin(
							new CelsiusToFahrenheit(
									new TermometroSimples("T1", 28)));
		System.out.println(t1.getTemperaturaMedia());
		System.out.println(t1.getTemperatura());
	}	
	
	private void run6() {
		Ambiente ambiente = DataSource.getAmbiente03(27);
		System.out.println(ambiente.getTermometro().getTemperaturaMedia());
	}
	
	
	private void run7() throws Exception{
		AmbienteNTermometros ambiente = DataSource.getAmbiente02(27);
		AbstractReport report = new OutliersReport(new FileMedium("C:\\Users\\fredericojorge\\outliers_report.txt"), ambiente, 15, 40);		
//		AbstractReport report = new TemperatureReport(new FileMedium("C:\\Users\\fredericojorge\\report.txt"), ambiente);
		report.doReport();
	}	
		
	
	public static void main(String[] args) throws Exception {
		(new App()).run7();
	}


}
