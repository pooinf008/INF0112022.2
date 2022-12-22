package br.ifba.inf011.criacional.afm;

import br.ifba.inf011.criacional.fm.model.atuadores.Atuador;
import br.ifba.inf011.criacional.fm.model.exception.AppException;
import br.ifba.inf011.criacional.fm.model.termometro.Termometro;

public interface ComponenteFactory {
	
	public Termometro getTermometro() throws AppException;
	public Atuador getAtuador() throws AppException;
	public void config(String conf) throws AppException;
	
	

}
