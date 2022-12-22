package br.ifba.inf011.criacional.afm;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.atuadores.AtuadorWarehouse;
import br.ifba.inf011.criacional.fm.model.exception.AppException;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroWarehouse;

public class ComponenteAltaFactory extends GenericComponenteFactory implements ComponenteFactory{

	public ComponenteAltaFactory(String conf) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(conf);
	}
	
	public ComponenteAltaFactory() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super();
	}	

	public void init() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.termometroWarehouse = new TermometroWarehouse("br.ifba.inf011.criacional.fm.model.termometro.TermometroAltaFactory");		
		this.atuadorWarehouse = new AtuadorWarehouse("br.ifba.inf011.criacional.fm.model.atuadores.ResfriadorFactory");			
	}

}
