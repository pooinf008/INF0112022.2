package br.ifba.inf011.model.proxy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Set;
import java.util.StringTokenizer;

import br.ifba.inf011.model.AmbienteNTermometros;

public class ClienteAmbiente implements AmbienteNTermometros{

	public void run() throws IOException, InterruptedException {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.ask("T1"));
			Thread.sleep(1000);
		}	
	}
	
	public TemperaturaInstante ask(String id) throws IOException {
		Socket socket = new Socket("localhost", 123);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write("? " + id);
		bw.newLine();
		bw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String descricao = br.readLine();
		socket.close();
		StringTokenizer st = new StringTokenizer(descricao, "!");
		Double temperatura = Double.valueOf(st.nextToken());
		Long instante = Long.valueOf(st.nextToken());
		return new TemperaturaInstante(temperatura, instante);
	}
	
	@Override
	public double getTemperatura(String id) {
		try {
			return this.ask(id).getTemperatura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public Set<String> getIds() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		(new ClienteAmbiente()).run();
	}




	
}
