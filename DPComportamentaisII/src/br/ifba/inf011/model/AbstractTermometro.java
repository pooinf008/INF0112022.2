package br.ifba.inf011.model;

import java.util.Random;

import br.ifba.inf011.model.iterator.TermometroIterator;

public abstract class AbstractTermometro implements Termometro{
	
	private double latitude, longitude;
	private String id;
	private String version = "1.0";
	
	private TermometroIterator it = null;
	
	public AbstractTermometro(String id, double latitude, double longitude) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public String getId() {
		return this.id;
	}
	
	
	public AbstractTermometro() {
		this("ID" + Math.abs((new Random()).nextInt() % 100), (new Random()).nextFloat() * 100, (new Random()).nextFloat() * 100);
	}
	
	
	public String toString() {
		return String.format("%s (%.2f; %.2f) - v%s - ",this.id, this.latitude, this.longitude, this.version);   
	}
	
	public String toTab(int tab) {
		String s = "";
		for(int i = 0; i < tab; i++)
			s +="\t";
		return s;
	}
	
	public void updateFirmware(String version) {
		this.version = version;
	}
	
	@Override
	public TermometroIterator iterator() {
		if(this.it == null) {
			this.it = this.createIterator();
			this.it.reset();
		}	
		return this.it;
	}

	protected abstract TermometroIterator createIterator();	

}


