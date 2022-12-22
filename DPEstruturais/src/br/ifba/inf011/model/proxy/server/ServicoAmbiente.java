package br.ifba.inf011.model.proxy.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.ifba.inf011.model.AmbienteNTermometros;
import br.ifba.inf011.model.DataSource;

public class ServicoAmbiente {
	
	AmbienteNTermometros ambiente = DataSource.getAmbiente02(27);
	
	public void run() throws IOException {
		int id = 0;
		ServerSocket socket = new ServerSocket(123);
		System.out.println("Registrando....");
		while(true) {
			Socket cliente = socket.accept();
			(new Thread(new AmbienteService(id++, cliente, ambiente))).start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		(new ServicoAmbiente()).run();
	}

}
