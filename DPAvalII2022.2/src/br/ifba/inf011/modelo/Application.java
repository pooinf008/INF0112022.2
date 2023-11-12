package br.ifba.inf011.modelo;

import java.util.List;

import br.ifba.inf011.modelo.bridge.FullFormattedVisitor;
import br.ifba.inf011.modelo.bridge.HTMLFormatter;
import br.ifba.inf011.modelo.bridge.LaTeXFormatter;
import br.ifba.inf011.modelo.bridge.SummaryFormattedVisitor;
import br.ifba.inf011.modelo.visitor.JSonVisitor;
import br.ifba.inf011.modelo.visitor.ObraVisitor;
import br.ifba.inf011.modelo.visitor.XMLVisitor;

public class Application {
	
	private void questaoI() {
		
		List<Obra> obras = ObraDB.instance().getObras();
		
		XMLVisitor xmlVisitor = new XMLVisitor();
		JSonVisitor jsonVisitor = new JSonVisitor();
		for(Obra obra : obras) {
			obra.accept(xmlVisitor);
			obra.accept(jsonVisitor);
		}	
		
		System.out.println(xmlVisitor.getCode());
		System.out.println(jsonVisitor.getCode());
	}
	
	private void questaoII() {
		
		List<Obra> obras = ObraDB.instance().getObras();
		ObraVisitor formatter = new FullFormattedVisitor(new LaTeXFormatter());
		formatter.clear();
		
		for(Obra obra : obras) {
			obra.accept(formatter);
		}			
		
		System.out.println(formatter.getCode());
	}	
	
	public static void main(String[] args) {
		(new Application()).questaoII();
	}

}
