package br.ifba.inf011;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.cor.ControleHandle;
import br.ifba.inf011.cor.IntegralHandleTipoII;
import br.ifba.inf011.cor.OffHandle;
import br.ifba.inf011.cor.ProporcionalHandle;
import br.ifba.inf011.cor.ProporcionalHandleTipoII;
import br.ifba.inf011.strategy.AlgoritmoControle;
import br.ifba.inf011.strategy.ControleProporcional;

public class CoRControladorTipoII extends AbstractControlador implements Controlador{
	

	private ControleHandle controleHandle;
	
	public CoRControladorTipoII(Ambiente ambiente, double setPoint, double ganho) {
		super(ambiente, setPoint, ganho);
		
		this.controleHandle = new ProporcionalHandleTipoII(new IntegralHandleTipoII(new OffHandle()));
	}
	
	public CoRControladorTipoII(Ambiente ambiente) {
		this(ambiente, 27, 1.0);
	}
	

	public CoRControladorTipoII() {
		this(null);
	}
	
	public double monitorar(){
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		double valor_atuacao;
		this.historico.add(temperatura);
		this.diferenca.add(Math.abs(delta));
		valor_atuacao = this.controleHandle.calcularDeltaAtuacao(temperatura, delta, this.setPoint, this.energia, this.historico, 
																  this.diferenca, this.ganho, this.ambiente);

	    if(valor_atuacao > setPoint) {
	    	ambiente.esfriar(valor_atuacao);
	    }	
	    else{
	    	ambiente.aquecer(valor_atuacao);
	    }
		
		
		this.energia -= this.consumoRodada();
		return valor_atuacao;
	}
	

	public double consumoRodada() {
		return 1;
	}

	
}
