package br.ifba.inf011.model.iterator;

import br.ifba.inf011.model.Termometro;

public interface TermometroIterator {
	public void reset();
	public void next();
	public boolean hasNext();
	public Termometro termometro();
}
