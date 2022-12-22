package br.ifba.inf011.model.proxy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.StringTokenizer;

import br.ifba.inf011.model.AmbienteNTermometros;

public class AmbienteService implements Runnable {

	private Socket cliente;
	private int id;
	private AmbienteNTermometros ambiente;
	
	
	public AmbienteService(int id, Socket cliente, AmbienteNTermometros ambiente) {
		this.cliente = cliente;
		this.id = id;
		this.ambiente = ambiente;
	}	
	
	@Override
	public void run() {
		BufferedReader br;
		try {
			br = new BufferedReader(
					new	InputStreamReader(
							this.cliente.getInputStream()));
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(
							this.cliente.getOutputStream()));
			
			String msg = br.readLine();
			System.out.println("Mensagem recebida por " + this.id + msg);
			StringTokenizer tokenizer = new StringTokenizer(msg, "? ");
			String id = tokenizer.nextToken();
			Double temp = this.ambiente.getTemperatura(String.valueOf(id));
			Long instante = (new Date()).toInstant().getLong(ChronoField.INSTANT_SECONDS); 
			bw.write(temp + "!" + instante);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

}
