package br.ifba.inf011.criacional.afm;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.atuadores.AtuadorWarehouse;
import br.ifba.inf011.criacional.fm.model.exception.AppException;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroWarehouse;

public abstract class GenericComponenteFactory implements ComponenteFactory{
	
	protected String conf;
	protected TermometroWarehouse termometroWarehouse;
	protected AtuadorWarehouse atuadorWarehouse;
	
	public GenericComponenteFactory(String conf) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.conf = conf;
		this.init();
	}
	
	public GenericComponenteFactory() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.init();
	}	

	public abstract void init() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException;
	
	@Override
	public Termometro getTermometro() throws AppException {
		return this.termometroWarehouse.getTermometro(conf);
	}

	@Override
	public Atuador getAtuador() throws AppException {
		return this.atuadorWarehouse.getAtuador(conf);
	}

	@Override
	public void config(String conf) throws AppException {
		this.conf = conf;
		
	}


}
