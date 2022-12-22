package br.ifba.inf011.model;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractTermometro implements Termometro{
	
	private double latitude, longitude;
	private String id;
	protected String version = "1.0";
	
	public AbstractTermometro(String id, double latitude, double longitude) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public AbstractTermometro(String id) {
		this(id, (new Random()).nextFloat() * 100, (new Random()).nextFloat() * 100);
	}	
	
	public String getId() {
		return this.id;
	}
	
	public AbstractTermometro() {
		this("ID" + Math.abs((new Random()).nextInt() % 100), (new Random()).nextFloat() * 100, (new Random()).nextFloat() * 100);
	}
	
	
	public String toString() {
		return String.format("%s (%.2f; %.2f) - v%s - ", this.id, this.latitude, this.longitude, this.version);   
	}
	
	public String toTab(int tab) {
		String s = "";
		for(int i = 0; i < tab; i++)
			s +="\t";
		return s;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTermometro other = (AbstractTermometro) obj;
		return Objects.equals(id, other.id);
	}
	
	

}