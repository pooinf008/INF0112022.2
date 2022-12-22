package br.ifba.inf011.criacional.afm.fm;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.afm.ComponenteAltaFactory;
import br.ifba.inf011.criacional.afm.ComponenteFactory;

public class AFComponenteAltaFactory implements ComponenteCreator{

	@Override
	public ComponenteFactory createComponenteFactory() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		return new ComponenteAltaFactory();
	}

}
