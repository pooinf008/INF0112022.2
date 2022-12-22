package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.iterator.TermometroIterator;

public abstract class NoComposto extends AbstractTermometro implements Termometro{
	
	
	private class NoCompostoIterator implements TermometroIterator{

		private Termometro current;
		private int filhoId;
		
		@Override
		public void reset() {
			this.current = null;
			this.filhoId = 0;
			for(Termometro t : NoComposto.this.filhos)
				t.iterator().reset();
		}
		
		@Override
		public void next() {
			if (this.current == null)
				this.current = NoComposto.this;
			else if (this.current == NoComposto.this) {
				this.current = NoComposto.this.filhos.get(filhoId);
				this.current.iterator().next();
			}else if (this.current != NoComposto.this && this.current.iterator().hasNext()) {
				this.current.iterator().next();
			}else if(this.filhoId < NoComposto.this.filhos.size() - 1) {
				this.filhoId++;
				this.current = NoComposto.this.filhos.get(filhoId);
				this.current.iterator().next();
			}
				
		}

		@Override
		public boolean hasNext() {
			if (this.current == null)
				return true;
			if (this.current == NoComposto.this) {
				return true;
			}if (this.current != NoComposto.this && this.current.iterator().hasNext()) {
				return true;
			}if(this.filhoId < NoComposto.this.filhos.size() - 1) {
				return true;
			}
			return false;
		}

		@Override
		public Termometro termometro() {
			if (this.current == NoComposto.this)
				return NoComposto.this;
			else	
				return this.current.iterator().termometro();
		}
	}
	
	
	protected List<Termometro> filhos;
	
	
	public NoComposto() {
		this.filhos = new ArrayList<Termometro>();
	}
	
	public void addTermometro(Termometro filho) {
		this.filhos.add(filho);
	}
	
	protected boolean hasChild() {
		return this.filhos.size() > 0; 
	}

	public abstract List<Temperatura> getTemperatura();
	
	public abstract String getDescricao();
	
	public String toString() {
		String s = super.toString() + 
				   this.getDescricao(); 
		for(Termometro termometro : this.filhos)
			s = s + termometro.toString() + "\n";
		return s;
	}
	
	public String toTab(int tab) {
		String s = super.toTab(tab+1) + super.toString() + this.getDescricao() + "\n";
		for(Termometro termometro : this.filhos)
			s = s + termometro.toTab(tab+1);
		return s;
	}

	public int qtdeFilhos() {
		return this.filhos.size();
	}

	public String idFilhos() {
		String ids = "[";
		for(Termometro termometro : this.filhos)
			ids = ids + termometro.getId() + " ";
		return ids + "]";
	}	
	
	@Override
	protected TermometroIterator createIterator() {
		return new NoComposto.NoCompostoIterator();
	};	
	

}
