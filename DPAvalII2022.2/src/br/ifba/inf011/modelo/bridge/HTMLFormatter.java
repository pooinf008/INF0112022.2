package br.ifba.inf011.modelo.bridge;

public class HTMLFormatter implements Formatter{
	
	private String codigo;
	
	public void init() {
		this.codigo = "<HTML>\n";
		this.codigo += "<HEAD></HEAD>\n";
		this.codigo += "<BODY>\n";
	}

	@Override
	public void end() {
		this.codigo += "</BODY>\n";
	}

	@Override
	public String report() {
		return this.codigo;
	}

	@Override
	public void bold(String str) {
		this.codigo += ("<bold>" + str+ "</bold>\n");
		
	}

	@Override
	public void italic(String str) {
		this.codigo += ("<italic>" + str+ "</italic>\n");		
	}

	@Override
	public void standard(String str) {
		this.codigo += str;
	};
	
	@Override
	public void comment(String str) {
		this.codigo += ("<!-- " + str + " -->\n");
	}

	@Override
	public void code(String str) {
		this.codigo += "<code>\n";
		this.codigo += str;
		this.codigo += "\n</code>\n";
		
	};	
	
}
