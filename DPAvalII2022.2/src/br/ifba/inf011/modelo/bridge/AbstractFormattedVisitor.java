package br.ifba.inf011.modelo.bridge;

import br.ifba.inf011.modelo.visitor.ObraVisitor;

public abstract class AbstractFormattedVisitor implements ObraVisitor{
	protected Formatter formatter;
	
	public AbstractFormattedVisitor(Formatter formatter) {
		this.formatter = formatter;
		this.clear();
	}	

	@Override
	public String getCode() {
		this.formatter.end();
		return this.formatter.report();
	}

	@Override
	public void clear() {
		this.formatter.init();
	}

}
