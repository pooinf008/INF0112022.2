package br.ifba.inf011.builder.model;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.Ambiente;
import br.ifba.inf011.builder.ConstrutorControlador;
import br.ifba.inf011.criacional.fm.model.atuadores.Estabilizador;
import br.ifba.inf011.criacional.fm.model.atuadores.Resfriador;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroAlta;
import br.ifba.inf011.criacional.fm.model.termometro.TermometroFaixa;

public class ControladorDict {
	
	private Map<String, Controlador> controladores;
	private Ambiente ambiente;
	
	private static ControladorDict instancia;
	
	
	
	public static ControladorDict getInstance(Ambiente ambiente) {
		if(ControladorDict.instancia == null)
			ControladorDict.instancia=  new ControladorDict(ambiente);
		return ControladorDict.instancia;
	}
	
	private ControladorDict(Ambiente ambiente) {
		this.controladores = new HashMap<String, Controlador>();
		this.ambiente = ambiente;
		this.init();
	}

	public void init() {
		
		ConstrutorControlador construtorControladores = new ConstrutorControlador();

		Controlador controlador = construtorControladores
				.reset()
				.withAtuador(new Estabilizador())
				.withTermometro(new TermometroFaixa())
				.setTemperaturaMaxima(29)
				.setTemperaturaMinima(26)
				.build(this.ambiente);
		
		this.controladores.put("ControladorFaixa", controlador);
		
		Controlador controlador2 = construtorControladores
				.reset()
				.withAtuador(new Resfriador())
				.withTermometro(new TermometroAlta())
				.setTemperaturaMaxima(30)
				.build(this.ambiente);
		
		this.controladores.put("ControladorAlta", controlador2);		
		
	}
	
	
	public void save(String nome, Controlador controlador) {
		this.controladores.put(nome, controlador);
	}
	
	
	public Controlador giveMe(String nome) {
		return this.controladores.get(nome).prototipar();
	}
	

}
