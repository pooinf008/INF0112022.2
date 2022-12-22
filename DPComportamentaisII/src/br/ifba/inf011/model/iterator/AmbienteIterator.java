package br.ifba.inf011.model.iterator;

import br.ifba.inf011.model.Termometro;

public interface AmbienteIterator {
	public void reset();
	public void next();
	public boolean hasNext();
	public Termometro termometro();
}
