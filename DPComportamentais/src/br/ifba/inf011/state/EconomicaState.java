package br.ifba.inf011.state;

import br.ifba.inf011.AbstractControlador;


public class EconomicaState implements ControladorInternalState{
	
	public double monitorar(AbstractControlador controlador){

		double temperatura = controlador.getAmbiente().getTemperatura();
		double delta = temperatura - controlador.getSetPoint();  
		double valor_atuacao = 0;
		controlador.getHistorico().add(temperatura);
		controlador.getDiferenca().add(Math.abs(delta));
		
		if(controlador.getHistorico().size() % 2 == 0)
			return 0;
		
		if(Math.abs(delta) > 0.1 * controlador.getSetPoint()) {
			valor_atuacao = Math.abs(delta * controlador.getGanho());
		    if(delta > 0) {
		    	controlador.getAmbiente().esfriar(valor_atuacao);
		    }	
		    else{
		    	controlador.getAmbiente().aquecer(valor_atuacao);
		    }
		}
		controlador.consumir(1.0);
		return valor_atuacao;
	}	

}
