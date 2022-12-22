package br.ifba.inf011.builder.model;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.criacional.fm.model.exception.AppException;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;
import br.ifba.inf011.prototype.Prototype;

public interface Controlador extends Prototype<Controlador>{
	public void monitorar() throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException;
	public void monitorar(Ambiente ambiente) throws InterruptedException, AppException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException;	
	public Termometro getTermometro();
}
