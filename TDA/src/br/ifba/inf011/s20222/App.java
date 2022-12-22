package br.ifba.inf011.s20222;

import java.util.Random;

public class App {
	
	
	public static void main(String[] args) {
		(new App()).run();
	}

	private void run() {
		
		Random rd = new Random();
		Alarme alarme = new Alarme(15.0, 30.0);
		
		for(int i = 0; i < 10; i++) {
			Double temperatura = rd.nextDouble(-10, 50);
			try {
				alarme.lerTemperatura(temperatura);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
