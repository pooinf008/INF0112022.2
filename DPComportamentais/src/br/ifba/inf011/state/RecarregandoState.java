package br.ifba.inf011.state;

import br.ifba.inf011.AbstractControlador;


public class RecarregandoState implements ControladorInternalState{
	
	public double monitorar(AbstractControlador controlador){
		controlador.consumir(-0.5);
		return 0;
	}	

}
