package br.ifba.inf011.criacional.fm.model.termometro;

public class TermometroFaixa extends GenericTermometro implements Termometro{
	
	public TermometroFaixa() {
		this(0,0);
	}
	
	public TermometroFaixa(double minima, double maxima) {
		this.setTemperaturaMinima(minima);		
		this.setTemperaturaMaxima(maxima);
	}
	
	public TermometroFaixa(TermometroFaixa termometroFaixa) {
		super(termometroFaixa);
	}	

	public void processaTemperatura(double temperatura) {
		if(temperatura > this.tempMaxima || temperatura < this.tempMinima)
			this.alarme.println("Termometro FAIXA: [ATENÇÃO]" + temperatura);
		else
			this.padrao.println("Termometro FAIXA: " + temperatura);
	}

	@Override
	public void config(String conf) {
		double[] temps = this.parseTemp(conf);
		this.setTemperaturaMinima(temps[0]);
		this.setTemperaturaMaxima(temps[1]);
	}

	@Override
	public Termometro prototipar() {
		return new TermometroFaixa(this);
	}
	
	

}
