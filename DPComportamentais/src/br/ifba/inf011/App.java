package br.ifba.inf011;

import br.ifba.inf011.strategy.ControleProporcional;
import br.ifba.inf011.tm.ControleTemplate;

import java.util.ArrayList;

import br.ifba.inf011.memento.SnapshotWarehouse;
import br.ifba.inf011.observer.ChangeStrategyObserver;
import br.ifba.inf011.observer.LogObserver;
import br.ifba.inf011.strategy.AlgoritmoControle;
import br.ifba.inf011.strategy.ControleIntegral;

public class App implements ChangeStrategyObserver {
	
	public App(){
		
	}	
	
	public void rodarState() throws InterruptedException{
		
		Ambiente ambiente = new Ambiente("AMB01");
		ControladorState controlador = new ControladorState();
		int i = 0;
		
		while(controlador.hasEnergia()) {
			ambiente.randomizar();
			double temperatura = ambiente.getTemperatura();
			double delta = controlador.monitorar(ambiente);
			i++;
			System.out.println(i + ") Temperatura \t Ambiente " + temperatura + "°\t Atuação: " + delta + "°\t(" + controlador.getEnergia() + ")");
			Thread.sleep(100);
		}
		
	}	
	
	
	public void rodarMemento() throws InterruptedException{
		
		
		LogObserver log = new LogObserver();
		Ambiente ambiente = new Ambiente("AMB01");
		StrategyControlador controlador = new StrategyControlador();
		int i = 0;
		
		SnapshotWarehouse warehouse = new SnapshotWarehouse(controlador);
		
		controlador.registrarChangeStrategyObserver(this);
		controlador.registrarChangeStrategyObserver(log);
		controlador.registrarLowBatObserver(log);
		
		
		controlador.setPoliticaAtuacao(new ControleProporcional());
		
		while(controlador.hasEnergia()) {
			
			if(i%10 == 0) {
				System.out.println("Salvando PONTO "+ i);
				warehouse.save("PONTO " + i);
				controlador.setPoliticaAtuacao(new ControleIntegral());
			}	
			else
				controlador.setPoliticaAtuacao(new ControleProporcional());
				
			
			ambiente.randomizar();
			double temperatura = ambiente.getTemperatura();
			double delta = controlador.monitorar(ambiente);
			i++;
			System.out.println(i + ") Temperatura \t Ambiente " + temperatura + "°\t Atuação: " + delta + "°");
			if(i == 50)
				warehouse.undo("PONTO 10");
			Thread.sleep(100);
		}
		
		
		
		
	}	
	
	public void rodarStrategy() throws InterruptedException{
		
		
		LogObserver log = new LogObserver();
		Ambiente ambiente = new Ambiente("AMB01");
		StrategyControlador controlador = new StrategyControlador();
		int i = 0;
		
		controlador.registrarChangeStrategyObserver(this);
		controlador.registrarChangeStrategyObserver(log);
		controlador.registrarLowBatObserver(log);
		
		
		controlador.setPoliticaAtuacao(new ControleProporcional());
		
		while(controlador.hasEnergia()) {
			
			if(i%10 == 0) {
				controlador.setPoliticaAtuacao(new ControleIntegral());
				controlador.save();
			}	
			else
				controlador.setPoliticaAtuacao(new ControleProporcional());
			
			if(i%25 == 0) {
				controlador.undo();
			}
				
			
			ambiente.randomizar();
			double temperatura = ambiente.getTemperatura();
			double delta = controlador.monitorar(ambiente);
			i++;
			System.out.println(i + ") Temperatura \t Ambiente " + temperatura + "°\t Atuação: " + delta + "°");
			Thread.sleep(100);
		}
		
	}
	
	public void rodarCoR() throws InterruptedException{
		
		Ambiente ambiente = new Ambiente("AMB01");
		CoRControlador controlador = new CoRControlador();
		int i = 0;
		
		while(controlador.hasEnergia()) {
			ambiente.randomizar();
			double temperatura = ambiente.getTemperatura();
			double delta = controlador.monitorar(ambiente);
			i++;
			System.out.println(i + ") Temperatura \t Ambiente " + temperatura + "°\t Atuação: " + delta + "°");
			Thread.sleep(100);
		}
		
	}	
	
	public void rodarTM() throws InterruptedException, FaultControladorException{
		
		Ambiente ambiente = new Ambiente("AMB01");
		ControleTemplate controlador = new br.ifba.inf011.tm.ControleProporcional();
		int i = 0;
		
		while(controlador.hasEnergia()) {
			ambiente.randomizar();
			double temperatura = ambiente.getTemperatura();
			double delta = controlador.monitorar(ambiente);
			i++;
			System.out.println(i + ") Temperatura \t Ambiente " + temperatura + "°\t Atuação: " + delta + "°");
			Thread.sleep(100);
		}
		
	}	
	
	public static void main(String[] args) throws InterruptedException, FaultControladorException{
		(new App()).rodarState();
	}

	@Override
	public void strategyChanged(String tipoAntigo, String novo) {
		System.out.println(">>> Mudou do Tipo " + tipoAntigo + " para o " + novo);
	}

}	

