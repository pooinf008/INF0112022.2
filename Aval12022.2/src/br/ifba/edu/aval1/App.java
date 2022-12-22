package br.ifba.edu.aval1;

import java.lang.reflect.InvocationTargetException;

import br.ifba.edu.aval1.model.Algoritmo;
import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Compilador;
import br.ifba.edu.aval1.model.Lang;
import br.ifba.edu.aval1.model.Repeticao;
import br.ifba.edu.aval1.model.Selecao;
import br.ifba.edu.aval1.model.TipoRepeticao;
import br.ifba.edu.aval1.model.q1_2c.ConstrutorRepeticao;
import br.ifba.edu.aval1.model.q2_2c.TerminoFaseEvent;
import br.ifba.edu.aval1.model.q2_2c.TerminoFaseListener;
import br.ifba.edu.aval1.q1.LanguageFactoryWarehouse;
import br.ifba.edu.aval1.q1.C.CRepeticao;

public class App implements TerminoFaseListener{
	
	public Algoritmo makeAlgorithm(Lang language) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		LanguageFactoryWarehouse.registerLanguageFactory(language);
		
		Bloco main = LanguageFactoryWarehouse.createBloco();
		main.addComando(LanguageFactoryWarehouse.createComandoSimples("int x"));
		main.addComando(LanguageFactoryWarehouse.createComandoSimples("int y"));
		main.addComando(LanguageFactoryWarehouse.createComandoSimples("x = 0"));
		main.addComando(LanguageFactoryWarehouse.createComandoSimples("y = 50"));

		Selecao selecao = LanguageFactoryWarehouse.createSelecao(LanguageFactoryWarehouse.createCondicao("x%2==0"), LanguageFactoryWarehouse.createComandoSimples("printf(\"%d\", x)"), LanguageFactoryWarehouse.createComandoSimples("printf(\"%o\", x)"));
		
		Bloco blocoRepeticao = LanguageFactoryWarehouse.createBloco();
		blocoRepeticao.addComando(LanguageFactoryWarehouse.createComandoSimples("x++"));
		blocoRepeticao.addComando(selecao);
		Repeticao repeticao = LanguageFactoryWarehouse.createRepeticao(LanguageFactoryWarehouse.createCondicao("x<y"), blocoRepeticao);
		
		CRepeticao cRepeticao = new ConstrutorRepeticao().reset()
														 .tipo(TipoRepeticao.tr_while)
														 .withControl("i")
														 .build("<100");
		main.addComando(cRepeticao);
		Algoritmo alg = LanguageFactoryWarehouse.createAlgoritmo(main); 
		
		return alg;
	}
	
	
	public void executar(Lang lang) throws Exception {
		Algoritmo alg = this.makeAlgorithm(lang);
		Compilador compilador = new Compilador(lang);
		compilador.addTerminoFaseListener(this);
		compilador.compilar(alg);
	}
	
	private void run() {
		try {
			this.executar(Lang.C);
		} catch (Exception e) {
			System.out.println("Erro na geração do programa...");
			e.printStackTrace();
		}
	}
	
	private void run2() {
		ConstrutorRepeticao cr = new ConstrutorRepeticao();
		CRepeticao repeticao = cr.reset()
								  .tipo(TipoRepeticao.tr_while)
								  .withControl("i")
								  .build("<100");
		System.out.println(repeticao.getValor());
	}	
	

	public static void main(String[] args) throws Exception {
		(new App()).run();
	}


	@Override
	public void notifyTerminoFase(TerminoFaseEvent event) {
		System.out.println(event.toString());
		
	}



	
}
