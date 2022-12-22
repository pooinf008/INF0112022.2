package br.ifba.inf011.criacional.afm.fm;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.afm.ComponenteFactory;
import br.ifba.inf011.criacional.afm.TipoComponenteFactory;
import br.ifba.inf011.criacional.fm.model.exception.AppException;

public abstract class ComponenteFactoryWarehouse {
	
	private static ComponenteCreator creator;
	
	public static void registerComponenteCreator(ComponenteCreator creator) {
		ComponenteFactoryWarehouse.creator = creator;
	}
	
	public static void registerComponenteCreator(TipoComponenteFactory tipo) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		ComponenteFactoryWarehouse.registerComponenteCreator(tipo.factoryName());	
	}
	
	public static void registerComponenteCreator(String creator) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		ComponenteFactoryWarehouse.registerComponenteCreator((ComponenteCreator) Class.forName(creator).getConstructor().newInstance()); 
	}	
	
	
	public static ComponenteFactory getComponenteFactory(String conf) throws AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		ComponenteFactory factory = ComponenteFactoryWarehouse.creator.createComponenteFactory();
		factory.config(conf);
		return factory;
	}

}
