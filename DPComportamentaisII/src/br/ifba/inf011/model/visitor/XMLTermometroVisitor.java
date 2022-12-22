package br.ifba.inf011.model.visitor;

import br.ifba.inf011.model.NoFusor;
import br.ifba.inf011.model.NoRoteamento;
import br.ifba.inf011.model.TermometroSimples;

public class XMLTermometroVisitor implements TermometroVisitor{
	
	private String xml;
	
	public XMLTermometroVisitor(){
		this.xml = "";
	}

	@Override
	public void visitTermometroSimples(TermometroSimples ts) {
		String node = "<TermometroSimples id=" + ts.getId() +">\n";
		node = node +  "\t<TemperaturaReferencia>" + ts.getTemperaturaReferencia() + "</TemperaturaReferencia>\n";
		node = node +  "\t<TemperaturaAtual>" + ts.getTemperatura().get(0).getTemperaturaMedia() + "</TemperaturaAtual>\n";
		node = node + "</TermometroSimples>\n";
		this.xml = this.xml + node;
	}

	@Override
	public void visitNoFusor(NoFusor nf) {
		String node = "<NoFusor id=" + nf.getId() +">\n";
		node = node +  "\t<NumeroFilhos>" + nf.qtdeFilhos() + "</NumeroFilhos>\n";
		node = node +  "\t<IdFilhos>" + nf.idFilhos() + "</IdFilhos>\n";
		node = node +  "\t<TemperaturaMedia>" + nf.getTemperatura().get(0).getTemperaturaMedia() + "</TemperaturaMedia>\n";
		node = node + "</NoFusor>\n";
		this.xml = this.xml + node;
	}

	@Override
	public void visitNoRoteamento(NoRoteamento nr) {
		String node = "<NoRoteamento id=" + nr.getId() +">\n";
		node = node +  "\t<NumeroFilhos>" + nr.qtdeFilhos() + "</NumeroFilhos>\n";
		node = node +  "\t<IdFilhos>" + nr.idFilhos() + "</IdFilhos>\n";
		node = node + "</NoRoteamento>\n";
		this.xml = this.xml + node;
		
	}
	
	public String getXML() {
		return "<Ambiente>\n" + this.xml + "</Ambiente>\n";
	}
	

}
