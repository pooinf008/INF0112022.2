package br.ifba.inf011;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.builder.model.Controlador;
import br.ifba.inf011.criacional.fm.model.exception.AppException;

public class AmbienteThread implements Runnable{

	private Controlador controlador;
	private Ambiente ambiente = null;

	public AmbienteThread(Controlador controlador, Ambiente ambiente) {
		super();
		this.controlador = controlador;
		this.ambiente = ambiente;
	}
	
	public AmbienteThread(Controlador controlador) {
		super();
		this.controlador = controlador;
	}
	


	@Override
	public void run() {
		try {
			if(ambiente == null)
				controlador.monitorar();
			else
				controlador.monitorar(this.ambiente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
