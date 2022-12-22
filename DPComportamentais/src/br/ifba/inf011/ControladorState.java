package br.ifba.inf011;

import br.ifba.inf011.state.ControladorInternalState;
import br.ifba.inf011.state.DesligadoState;
import br.ifba.inf011.state.OperacionalState;
import br.ifba.inf011.state.RecarregandoState;

public class ControladorState extends AbstractControlador{

//	private OperacionalState state = new OperacionalState();
	private ControladorInternalState state = new OperacionalState();	
	
	public ControladorState(Ambiente ambiente, double setPoint, double ganho) {
		super(ambiente, setPoint, ganho);
	}
	
	public ControladorState(Ambiente ambiente) {
		this(ambiente, 27, 1.0);
	}
	

	public ControladorState() {
		this(null);
	}	

	@Override
	public double monitorar() {
		return this.state.monitorar(this);
	}

	@Override
	public double consumoRodada() {
		// TODO Auto-generated method stub
		return 1.0;
	}
	
	public void economizar() {
		
	}

	public void recarregar() {
		
	}
	
	public void desligar() {
		
	}
	
	public void ligar() {
		
	}
	
	
	
}
