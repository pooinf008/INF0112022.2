package br.ifba.inf011.model.bridge;

public interface Medium {
	
	public void prepare() throws Exception;
	public void write(String string) throws Exception;
	public void close() throws Exception;
	

}
