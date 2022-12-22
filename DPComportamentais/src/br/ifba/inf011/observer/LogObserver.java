package br.ifba.inf011.observer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogObserver implements ChangeStrategyObserver, LowBatObserver{
	
	public void doLog(String info) throws IOException {
        // Cria arquivo
        File file = new File("C:\\Users\\fredericojorge\\Documents\\log.txt");
        // Se o arquivo nao existir, ele gera
        if (!file.exists()) {
            file.createNewFile();
        }
        // Prepara para escrever no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(info);
        bw.newLine();
        bw.close();		
	}

	@Override
	
	public void strategyChanged(String tipoAntigo, String novo) {
		DateFormat dtFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		try {
			this.doLog("[" + dtFormat.format(new Date()) + "] " + tipoAntigo + " >>>" + novo);
		}catch(IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

	@Override
	public void lowBat(double energy) {
		DateFormat dtFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		try {
			this.doLog("[" + dtFormat.format(new Date()) + "] LOW BAT: " + energy);
		}catch(IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

}
