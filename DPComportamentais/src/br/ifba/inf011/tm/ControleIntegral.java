package br.ifba.inf011.tm;

import java.util.List;

import br.ifba.inf011.Ambiente;

public class ControleIntegral extends ControleTemplate {

	@Override
	protected double getConsumoRodada() {
		return 2.0;
	}

	@Override
	protected double getValorAtuacao() {
		int qtdeAtuacao = (historico.size() > 5) ?
					  	  5 : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(i) - setPoint) + deltaHistorico;
		deltaHistorico = deltaHistorico / qtdeAtuacao;
		double tempAtuacao = deltaHistorico * ganho;
	    return -tempAtuacao;
	}

	@Override
	protected void logTipoAtuacao() {
		System.err.print("Integral\t");
	}

	@Override
	protected double atuar(double tempAtuacao) {
	    if(tempAtuacao > setPoint) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    return tempAtuacao;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
	}

}
