package br.ifba.inf011.modelo.bridge;

public interface Formatter {

	public void init();
	public void end();
	public String report();
	public void bold(String str);
	public void italic(String str);
	public void standard(String str);
	public void comment(String str);
	public void code(String str);

}
