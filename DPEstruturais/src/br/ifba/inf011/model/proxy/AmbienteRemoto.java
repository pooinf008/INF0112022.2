package br.ifba.inf011.model.proxy;

import java.io.IOException;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.ifba.inf011.model.AmbienteNTermometros;
import br.ifba.inf011.model.proxy.server.ClienteAmbiente;
import br.ifba.inf011.model.proxy.server.TemperaturaInstante;

public class AmbienteRemoto implements AmbienteNTermometros {
	

	public Map<String, TemperaturaInstante> cache;
	
	public AmbienteRemoto() {
		this.cache = new HashMap<String, TemperaturaInstante>();
	}
	
	@Override
	public double getTemperatura(String id) {
		TemperaturaInstante ti = this.cache.get(id);
		Long instanteAtual = (new Date()).toInstant().getLong(ChronoField.INSTANT_SECONDS);
		if(ti == null || (instanteAtual - ti.getInstante() > 1)) {
			ti = this.getTemperaturaRemote(id);
			this.cache.put(id, ti);
		}
		return ti.getTemperatura();
	}	
	
	public TemperaturaInstante getTemperaturaRemote(String id) {
		ClienteAmbiente cliente = new ClienteAmbiente();
		try {
			return cliente.ask(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<String> getIds() {
		return this.cache.keySet();
	}





}
