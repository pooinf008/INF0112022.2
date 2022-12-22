package br.ifba.inf011.cor;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class IntegralHandleTipoII extends AbstractControleHandle implements ControleHandle{

	
	public IntegralHandleTipoII(ControleHandle proximo) {
		super(proximo);
	}
	
	@Override
	public double calcularDeltaAtuacao(double temperatura, double delta, double setPoint, 
			double energia, List<Double> historico,
			List<Double> deltas, Double ganho, Ambiente ambiente) {
		
		
		double temp = historico.get(historico.size() - 1);
		int qtdeAtuacao = (historico.size() > 5) ?
					  	  5 : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(i) - setPoint) + deltaHistorico;
		
		deltaHistorico = deltaHistorico / qtdeAtuacao;
		double tempAtuacao = Math.abs(deltaHistorico * ganho);		
		
		if(energia > 5 && Math.abs(tempAtuacao) > 0.1 * setPoint) {
			System.err.print("Integral\t");
		    return (tempAtuacao + this.proximo.calcularDeltaAtuacao(temperatura, delta, setPoint, energia, historico, deltas, ganho, ambiente)) / 2;
		}
		
		return this.proximo.calcularDeltaAtuacao(temperatura, delta, setPoint, energia, historico, deltas, ganho, ambiente);
		
	}
	
}
