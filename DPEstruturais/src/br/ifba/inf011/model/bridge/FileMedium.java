package br.ifba.inf011.model.bridge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileMedium implements Medium{
	
	private BufferedWriter buffWrite;
	private String fileName;
	
	
	public FileMedium(String fileName) {
		this.fileName = fileName;
	}
	

	@Override
	public void prepare() throws IOException {
		System.out.println("Gerando pro arquivo : " + this.fileName);
		this.buffWrite =  new BufferedWriter(new FileWriter(this.fileName, true));
		
	}

	@Override
	public void write(String string) throws IOException {
		this.buffWrite.append(string + "\r\n");
	}

	@Override
	public void close() throws IOException {
		this.buffWrite.close();
		System.out.println("Geração concluida");		
		
	}

}
