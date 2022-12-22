package br.ifba.inf011.criacional.fm.model.termometro;

public class TermometroAlta extends GenericTermometro implements Termometro{

	public TermometroAlta() {
		this(0);
	}
	
	public TermometroAlta(double maxima) {
		this.setTemperaturaMaxima(maxima);
	}	

	public TermometroAlta(TermometroAlta termometroAlta) {
		super(termometroAlta);
	}

	public void processaTemperatura(double temperatura) {
		if(temperatura > this.tempMaxima)
			this.alarme.println("Termometro ALTA: [ATENÇÃO]" + temperatura);
		else
			this.padrao.println("Termometro Alta: " + temperatura);
	}

	@Override
	public void config(String conf) {
		double[] temps = this.parseTemp(conf);
		this.setTemperaturaMaxima(temps[1]);
	}

	@Override
	public Termometro prototipar() {
		return new TermometroAlta(this);
	}

}
