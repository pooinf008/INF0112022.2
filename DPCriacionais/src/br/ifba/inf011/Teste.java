package br.ifba.inf011;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ifba.inf011.criacional.fm.model.termometro.TermometroAlta;

public class Teste {
	
	public void run() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		String nomeClasse = "br.ifba.inf011.criacional.fm.model.termometro.TermometroAlta";
		
		TermometroAlta termometro = (TermometroAlta) Class.forName(nomeClasse).getConstructor().newInstance();

		System.out.println(termometro);
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Teste teste = new Teste();
		teste.run();
	}

}
