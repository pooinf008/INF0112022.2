package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.ifba.inf011.model.iterator.TermometroIterator;
import br.ifba.inf011.model.visitor.TermometroVisitor;

public class TermometroSimples extends AbstractTermometro implements Termometro{
	
	private class TermometroSimplesIterator implements TermometroIterator{

		private boolean returned = false;
		private TermometroSimples current;
		
		@Override
		public void reset() {
			this.returned = false;
			this.current = null;
		}

		@Override
		public void next() {
			this.returned = true;
			this.current = TermometroSimples.this;
		}

		@Override
		public boolean hasNext() {
			return !this.returned;
		}

		@Override
		public Termometro termometro() {
			return this.current;
		}
	}
	
	
	private double tempReferencia;
	
	public TermometroSimples(double tempReferencia) {
		this.tempReferencia= tempReferencia;
	}
	
	public List<Temperatura> getTemperatura() {
		Random random = new Random();
		tempReferencia += random.nextGaussian() * 1;
		List<Temperatura> temperaturas = new ArrayList<Temperatura>();
		temperaturas.add(new Temperatura(this.tempReferencia, 1)); 
		return temperaturas;
	}
	
	public String toString() {
		return super.toString() + tempReferencia;
	}
	
	public String toTab(int tab) {
		String s = super.toTab(tab+1) + super.toString() + "Termometro Simples: ";
		return s + toString() + "\n";
	}	
	
	public double getTemperaturaReferencia() {
		return this.tempReferencia;
	}

	public TermometroIterator createIterator() {
		return new TermometroSimples.TermometroSimplesIterator();
	}

	@Override
	public void accept(TermometroVisitor visitor) {
		visitor.visitTermometroSimples(this);
	}

}
