package br.ifba.inf011.model;

import java.util.List;

import br.ifba.inf011.model.iterator.Iteravel;
import br.ifba.inf011.model.visitor.TermometroVisitor;

public interface Termometro extends Iteravel{
	
	public List<Temperatura> getTemperatura();
	public String toTab(int tab);
	public void updateFirmware(String version);
	public String getId();
	public void accept(TermometroVisitor visitor);
	

}
