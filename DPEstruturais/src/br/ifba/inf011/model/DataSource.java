package br.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.adapter.MultiTermometro2Termometro;
import br.ifba.inf011.model.decorator.CelsiusToFahrenheit;
import br.ifba.inf011.model.decorator.FahrenheitToKelvin;

public class DataSource {
	
	
	public static AmbienteNTermometros getAmbiente02(double temp) {
		List<Termometro> termometros = new ArrayList<Termometro>();
		termometros.add(new TermometroSimples("T1", temp));
		termometros.add(new TermometroSimples("T2", temp));
		termometros.add(new TermometroSimples("T3", temp));
		termometros.add(new TermometroSimples("T4", temp));
		termometros.add(new TermometroSimples("T5", temp));
		return new AmbienteLocalNTermometros(termometros);
	}
	
	
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
		nr0.addTermometro(new MultiTermometro2Termometro(new MultiTermometro("multi01", 1000, 1000, temp)));		
		
		return new Ambiente(nr0);
	}
	
	public static Ambiente getAmbiente03(double temp) {
		Termometro t11 = new FahrenheitToKelvin(
								new CelsiusToFahrenheit(
										new TermometroSimples(temp)));
		Termometro t12 = new FahrenheitToKelvin(
							new CelsiusToFahrenheit(
									new TermometroSimples(temp)));
		Termometro t13 = new FahrenheitToKelvin(
				new CelsiusToFahrenheit(
						new TermometroSimples(temp)));

		NoRoteamento nr1 = new NoRoteamento();
		nr1.addTermometro(t11);
		nr1.addTermometro(t12);
		nr1.addTermometro(t13);
		

		Termometro t21 = new FahrenheitToKelvin(
				new CelsiusToFahrenheit(
						new TermometroSimples(temp)));
		Termometro t22 = new FahrenheitToKelvin(
				new CelsiusToFahrenheit(
						new TermometroSimples(temp)));

		NoRoteamento nr2 = new NoRoteamento();
		nr2.addTermometro(t21);
		nr2.addTermometro(t22);
		
		Termometro t31 = new FahrenheitToKelvin(
				new CelsiusToFahrenheit(
						new TermometroSimples(temp)));		
		Termometro t32 = new FahrenheitToKelvin(
				new CelsiusToFahrenheit(
						new TermometroSimples(temp)));

		NoFusor nf = new NoFusor();
		nf.addTermometro(t31);
		nf.addTermometro(t32);

		
		NoRoteamento nr0 = new NoRoteamento();
		Termometro t01 = new FahrenheitToKelvin(
				new CelsiusToFahrenheit(
						new TermometroSimples(temp)));		
		
		nr0.addTermometro(nr1);
		nr0.addTermometro(nr2);
		nr0.addTermometro(t01);
		nr0.addTermometro(nf);
		nr0.addTermometro(
				new FahrenheitToKelvin(
						new CelsiusToFahrenheit(
							new MultiTermometro2Termometro(
								new MultiTermometro("multi01", 1000, 1000, temp)))
						));		
		
		return new Ambiente(nr0);
	}	
	
	
	

}
