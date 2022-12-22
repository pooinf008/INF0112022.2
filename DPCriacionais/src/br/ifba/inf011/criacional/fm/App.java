package br.ifba.inf011.criacional.fm;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.afm.ComponenteAltaFactory;
import br.ifba.inf011.criacional.afm.ComponenteFactory;
import br.ifba.inf011.criacional.afm.ComponenteFaixaFactory;
import br.ifba.inf011.criacional.fm.model.Ambiente;
import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.atuadores.AtuadorWarehouse;
import br.ifba.inf011.criacional.fm.model.exception.AppException;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroAlta;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroAltaFactory;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroFactory;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroLock;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroLockFactory;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroWarehouse;
import br.ifba.inf011.criacional.fm.model.termometro.TipoTermometro;

public class App {
	
	
	
	public void rodar() throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		
//		TermometroFactory  termometroFactory= new TermometroFactory();
		
//		Termometro termometro2 = TermometroFactory.getFactory(null).getTermometro(TipoTermometro.TermometroLock, 30);		
		
//		TermometroWarehouse.registerCreator(new TermometroAltaFactory());
		
//		TermometroWarehouse.registerCreator("br.ifba.inf011.criacional.fm.model.termometro.TermometroFaixaFactory");		
//		AtuadorWarehouse.registerCreator("br.ifba.inf011.criacional.fm.model.atuadores.EstabilizadorFactory");		
		
		ComponenteFactory factory = new ComponenteFaixaFactory("25:30");
		
		Termometro termometro = factory.getTermometro();
		Atuador  atuador = factory.getAtuador();
		
		Ambiente ambiente = new Ambiente();
		while(true) {
			ambiente.randomizar();
			termometro.lerTemperatura(ambiente);
			atuador.atuar(ambiente);
			Thread.sleep(100);
		}
		
	}

	
	
	public static void main(String[] args) throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		(new App()).rodar();
	}

}	

