package br.ifba.inf011.model;

import br.ifba.inf011.model.iterator.TermometroIterator;
import br.ifba.inf011.model.visitor.TermometroVisitor;
import br.ifba.inf011.model.visitor.XMLTermometroVisitor;

public class App {

	private void run() {
		Ambiente ambiente = DataSource.getAmbiente01(27);
		System.out.println(ambiente);
	}
	
	private void run3() {
		Ambiente ambiente = DataSource.getAmbiente01(27);
		TermometroIterator it = ambiente.getTermometro().iterator();
		XMLTermometroVisitor visitor = new XMLTermometroVisitor();
		
		while(it.hasNext()) {
			it.next();
			Termometro termometro = it.termometro();
			termometro.accept(visitor);
		}
		
		System.out.println(visitor.getXML());
		
	}	
	
	
	private void run2() {
		Ambiente ambiente = DataSource.getAmbiente01(27);
		TermometroIterator it = ambiente.iterator();
		
		while(it.hasNext()) {
			it.next();
			System.out.println(it.termometro().getId() + " "+ it.termometro().getClass().getName());
		}
		
	}
	
	private void run4() {
		XMLTermometroVisitor xml = new XMLTermometroVisitor(); 
		Termometro t = new TermometroSimples(27);
		TermometroIterator it = t.iterator();
		System.out.println(t);
		while(it.hasNext()) {
			it.next();
			it.termometro().updateFirmware("2.0");
			it.termometro().accept(xml);
		}
		System.out.println(t);
		System.out.println(xml.getXML());
	}
	
	private void run5() {
		Ambiente ambiente = DataSource.getAmbiente01(27);
		System.out.println(ambiente);
		System.out.println("ATUALIZANDO O FIRMWARE!");
		TermometroIterator it = ambiente.iterator();
		while(it.hasNext()) {
			it.next();
			it.termometro().updateFirmware("2.0");
		}		
		System.out.println(ambiente);
	}
	
	private void run6() {
		Ambiente02 ambiente = new Ambiente02(27, 10);
		System.out.println(ambiente);
		System.out.println("ATUALIZANDO O FIRMWARE!");
		TermometroIterator it = ambiente.iterator();
		while(it.hasNext()) {
			it.next();
			it.termometro().updateFirmware("2.0");
		}		
		System.out.println(ambiente);
	}	
			
		
	
	
	public static void main(String[] args) {
		(new App()).run3();
	}


}
