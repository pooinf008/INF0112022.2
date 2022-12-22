package br.ifba.edu.aval1.q1;

import java.lang.reflect.InvocationTargetException;

import br.ifba.edu.aval1.model.Algoritmo;
import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Lang;
import br.ifba.edu.aval1.model.Repeticao;
import br.ifba.edu.aval1.model.Selecao;

public class LanguageFactoryWarehouse{ 
	
	private static AbstractLanguageFactory factory;
	
	public static void registerLanguageFactory(AbstractLanguageFactory factory) {
		LanguageFactoryWarehouse.factory = factory;
	}
	
	public static void registerLanguageFactory(Lang language) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		LanguageFactoryWarehouse.factory = (AbstractLanguageFactory) Class.forName(language.getFactoryName()).getConstructor().newInstance();
	}	
	
	public static Algoritmo createAlgoritmo(Bloco bloco) {
		return LanguageFactoryWarehouse.factory.createAlgoritmo(bloco);
	};
	
	public static Bloco createBloco() {
		return LanguageFactoryWarehouse.factory.createBloco();
	};
	
	public static Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo) {
		return LanguageFactoryWarehouse.factory.createSelecao(condicao, comandoPositivo);
	};
	
	public static Selecao createSelecao(ComandoSimples condicao, Comando comandoPositivo, 
								 Comando comandoNegativo) {
		return LanguageFactoryWarehouse.factory.createSelecao(condicao, comandoPositivo, comandoNegativo);
	};
	
	public static Repeticao createRepeticao(ComandoSimples condicao, Comando comando) {
		return LanguageFactoryWarehouse.factory.createRepeticao(condicao, comando);
	};	
	
	public	static ComandoSimples createComandoSimples(String comando) {
		return LanguageFactoryWarehouse.factory.createComandoSimples(comando);
	};
	
	public static ComandoSimples createCondicao(String comando) {
		return LanguageFactoryWarehouse.factory.createCondicao(comando);
	};	

}