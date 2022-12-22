package br.ifba.edu.aval1.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval1.model.q2_2c.TerminoFaseEvent;
import br.ifba.edu.aval1.model.q2_2c.TerminoFaseListener;
import br.ifba.edu.aval1.q2.StrategyLanguage;

public class Compilador {
	
	private List<TerminoFaseListener> listeners;
	
	private StrategyLanguage strategy;
	private Lang lang;
	
	public Compilador(Lang lang) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.setLanguage(lang);
		this.listeners = new ArrayList<TerminoFaseListener>();
	}
	
	public void setLanguage(Lang lang) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		this.lang = lang;
		this.strategy = (StrategyLanguage) Class.forName(lang.getStrategyLanguage()).getConstructor().newInstance();
	}
	
	public void compilar(Algoritmo algoritmo) throws Exception{
		this.strategy.verificarLexico(algoritmo);
		this.fireTerminoFaseEvent("Verificação Léxica");
		this.strategy.verificarSintaxe(algoritmo);
		this.fireTerminoFaseEvent("Verificação Sintática");
		this.strategy.verificarSemantica(algoritmo);
		this.fireTerminoFaseEvent("Verificação Semântica");
		this.strategy.gerarCodigo(algoritmo);
		this.fireTerminoFaseEvent("Geração de Código");
	}
	
	public void fireTerminoFaseEvent(String fase) {
		for(TerminoFaseListener listener : this.listeners)
			listener.notifyTerminoFase(new TerminoFaseEvent(this.lang, fase));
			
	}
	
	public void addTerminoFaseListener(TerminoFaseListener listener) {
		this.listeners.add(listener);
	}
	
	

}
