package br.ifba.inf011.modelo.bridge;

public class LaTeXFormatter implements Formatter{
	
	private String codigo;
	
	
	
	public void init() {
		this.codigo = "";
	}

	@Override
	public void end() {
		this.codigo += "";
	}

	@Override
	public String report() {
		return this.codigo;
	}

	@Override
	public void bold(String str) {
		this.codigo += ("\\textbf{" + str+ "}\n");
		
	}

	@Override
	public void italic(String str) {
		this.codigo += ("\\emph{" + str + "}\n");		
	}

	@Override
	public void standard(String str) {
		this.codigo += str;
	};
	
	@Override
	public void comment(String str) {
		this.codigo += ("% " + str + "\n");
	}

	@Override
	public void code(String str) {
		this.codigo += "\\begin{verbatim}\n";
		this.codigo += str;
		this.codigo +="\n\\end{verbatim}\n";
	};	
	
}
