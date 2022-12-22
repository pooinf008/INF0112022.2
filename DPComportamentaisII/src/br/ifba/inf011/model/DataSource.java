package br.ifba.inf011.model;

public class DataSource {
	
	
	
	public static Ambiente getAmbiente01(double temp) {
		Termometro t11 = new TermometroSimples(temp);
		Termometro t12 = new TermometroSimples(temp);
		Termometro t13 = new TermometroSimples(temp);

		NoRoteamento nr1 = new NoRoteamento();
		nr1.addTermometro(t11);
		nr1.addTermometro(t12);
		nr1.addTermometro(t13);

		Termometro t21 = new TermometroSimples(temp);
		Termometro t22 = new TermometroSimples(temp);

		NoRoteamento nr2 = new NoRoteamento();
		nr2.addTermometro(t21);
		nr2.addTermometro(t22);
		
		
		Termometro t31 = new TermometroSimples(temp);
		Termometro t32 = new TermometroSimples(temp);

		NoFusor nf = new NoFusor();
		nf.addTermometro(t31);
		nf.addTermometro(t32);

		
		NoRoteamento nr0 = new NoRoteamento();
		Termometro t01 = new TermometroSimples(temp);
		
		nr0.addTermometro(nr1);
		nr0.addTermometro(nr2);
		nr0.addTermometro(t01);
		nr0.addTermometro(nf);
		
		

		
		return new Ambiente(nr0);
	}
	
	
	
	

}
