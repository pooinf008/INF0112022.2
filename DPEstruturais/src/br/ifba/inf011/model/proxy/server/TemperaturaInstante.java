package br.ifba.inf011.model.proxy.server;

public class TemperaturaInstante {
	

	private Double temperatura;
	private Long instante;
	
	public TemperaturaInstante(Double temperatura, Long instante) {
		super();
		this.temperatura = temperatura;
		this.instante = instante;
	}
	
	public Double getTemperatura() {
		return temperatura;
	}

	public Long getInstante() {
		return instante;
	}

	

}
