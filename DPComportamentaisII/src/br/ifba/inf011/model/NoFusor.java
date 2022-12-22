package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.iterator.TermometroIterator;
import br.ifba.inf011.model.visitor.TermometroVisitor;

public class NoFusor extends NoComposto implements Termometro{
	
	
	public NoFusor() {
		
	}
	
	@Override
	public List<Temperatura> getTemperatura() {
		double valorTemperatura =  0;
		int qtdePontos = 0;
		for(int i = 0; i < this.filhos.size(); i++) {
			List<Temperatura> temperaturas = this.filhos.get(i).getTemperatura();
			for(int j=0; j < temperaturas.size(); j++) {
				Temperatura temperatura = temperaturas.get(j);
				valorTemperatura += temperatura.getTemperaturaMedia() * temperatura.getQtdePontos();
				qtdePontos += temperatura.getQtdePontos();
			}	
		}
		List<Temperatura> novaTemperaturas = new ArrayList<Temperatura>();
		novaTemperaturas.add(new Temperatura(valorTemperatura / qtdePontos, qtdePontos)); 
		return novaTemperaturas;
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "NO FUSOR";
	}

	@Override
	public void accept(TermometroVisitor visitor) {
		visitor.visitNoFusor(this);
	}


	
}	
