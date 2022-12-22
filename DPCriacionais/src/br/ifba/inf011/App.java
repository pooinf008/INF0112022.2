package br.ifba.inf011;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.builder.Construtor;
import br.ifba.inf011.builder.ConstrutorControlador;
import br.ifba.inf011.builder.Diretor;
import br.ifba.inf011.builder.ManualControladorConstrutor;
import br.ifba.inf011.builder.model.Controlador;
import br.ifba.inf011.builder.model.ControladorDict;
import br.ifba.inf011.builder.model.GenericControlador;
import br.ifba.inf011.criacional.afm.ComponenteAltaFactory;
import br.ifba.inf011.criacional.afm.ComponenteFactory;
import br.ifba.inf011.criacional.afm.ComponenteFaixaFactory;
import br.ifba.inf011.criacional.afm.TipoComponenteFactory;
import br.ifba.inf011.criacional.afm.fm.AFComponenteAltaFactory;
import br.ifba.inf011.criacional.afm.fm.AFComponenteFaixaFactory;
import br.ifba.inf011.criacional.afm.fm.ComponenteFactoryWarehouse;
import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.atuadores.AtuadorWarehouse;
import br.ifba.inf011.criacional.fm.model.atuadores.Estabilizador;
import br.ifba.inf011.criacional.fm.model.exception.AppException;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroAlta;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroAltaFactory;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroFactory;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroFaixa;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroLock;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroLockFactory;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroWarehouse;
import br.ifba.inf011.criacional.fm.model.termometro.TipoTermometro;

public class App {
	
	private ComponenteFactory factory;
	
	
	public App() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, AppException {
	}	
	
	public void rodar4() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InterruptedException, AppException {
		
		Ambiente ambiente = new Ambiente("AMB01");
		
		ControladorDict dicionario2 = ControladorDict.getInstance(ambiente);
		ControladorDict dicionario = ControladorDict.getInstance(ambiente);
		
		ConstrutorControlador construtorControlador = new ConstrutorControlador();		
		Controlador controlador2 = construtorControlador
				.reset()
				.withAtuador(new Estabilizador())
				.withTermometro(new TermometroAlta())
				.setTemperaturaMaxima(28)
				.build(ambiente);
		
		
		dicionario.save("ControladorMisto", controlador2);
		
		Controlador controlador = dicionario2.giveMe("ControladorMisto");
		controlador.monitorar();
		
	}
	
	
	
	public void rodar3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InterruptedException, AppException {
		
		ConstrutorControlador construtorManual = new ConstrutorControlador();
		
		Ambiente ambiente = new Ambiente("AMB01");
		Ambiente ambiente2 = new Ambiente("AMB02");
		
		Controlador controlador = construtorManual
						.reset()
						.withAtuador(new Estabilizador())
						.withTermometro(new TermometroAlta())
						.setTemperaturaMaxima(28)
						.build(ambiente);
		
		Controlador controlador2 = controlador.prototipar();
		
		new Thread((new AmbienteThread(controlador))).start();
		new Thread((new AmbienteThread(controlador2, ambiente2))).start();
		
	}
		
	
	
	public void rodar2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InterruptedException, AppException {
		
		ManualControladorConstrutor construtorManual = new ManualControladorConstrutor();
		ConstrutorControlador construtor = new ConstrutorControlador();
		Diretor diretor = new Diretor(construtor);
		Ambiente ambiente = new Ambiente("AMB01");
		diretor.makeControladorAltaPadrao();
		Controlador controlador = construtor.build(ambiente);
		
		diretor.setConstrutor(construtorManual);
		diretor.makeControladorAltaPadrao();
		String manual = construtorManual.build(ambiente);
		
		System.out.println(manual);
		
		controlador.monitorar();
	}
	
	public void rodar() throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{

		ComponenteFactoryWarehouse.registerComponenteCreator(TipoComponenteFactory.Faixa);
		this.factory = ComponenteFactoryWarehouse.getComponenteFactory("26:30");
		
		Termometro termometro = factory.getTermometro();
		Atuador  atuador = factory.getAtuador();
		
		Ambiente ambiente = new Ambiente("AMB01");
		while(true) {
			ambiente.randomizar();
			termometro.lerTemperatura(ambiente);
			atuador.atuar(ambiente);
			Thread.sleep(100);
		}
		
		
		
	}

	
	
	public static void main(String[] args) throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		(new App()).rodar4();
	}

}	

