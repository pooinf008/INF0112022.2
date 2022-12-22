package br.ifba.inf011.criacional.fm.model.termometro;

public class TermometroLock extends GenericTermometro implements Termometro{
	
	private boolean lock;

	public TermometroLock(double maxima) {
		this.setTemperaturaMaxima(maxima);
		this.lock = false;
	}
	
	public TermometroLock() {
		this(30);
	}
	
	public TermometroLock(TermometroLock termometroLock) {
		super(termometroLock);
		this.init();
	}		
	
	private void init() {
		this.reset();
	}
	
	public void reset() {
		this.lock = false;
	}
	
	public void config(String conf) {
		double[] temps = this.parseTemp(conf);
		this.setTemperaturaMaxima(temps[1]);
	};	
	
	public void processaTemperatura(double temperatura) {
		if(temperatura > this.tempMaxima || this.lock) {
			this.lock = true;
			this.alarme.println("Termometro LOCK: [ATENÇÃO]" + temperatura);
		}else
			this.padrao.println("Termometro lock: " + temperatura);
	}

	@Override
	public Termometro prototipar() {
		return new TermometroLock(this);
	}

}
