package br.ifba.edu.aval1.q1.C;

import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.ComandoSimples;
import br.ifba.edu.aval1.model.Repeticao;
import br.ifba.edu.aval1.model.TipoRepeticao;

public class CRepeticao extends Repeticao{
	
	private TipoRepeticao tipo;
	private String varControle;
	private String inicializacao;
	private String terminacao;
	private String iteracao;

	public CRepeticao(TipoRepeticao tipo, String varControle, String inicializacao,
				      String iteracao, String terminacao, Comando comando){
		this.tipo = tipo;
		 this.varControle = varControle;
		 this.inicializacao = inicializacao;
		 this.iteracao = iteracao; 
		 this.terminacao = terminacao;
		 this.comando = comando;		
	}
	
	public CRepeticao(ComandoSimples condicao, Comando comando) {
		super(condicao, comando);
	}

	@Override
	public String getValor() {
		if(this.tipo == TipoRepeticao.tr_for)
			return this.getForValor();
		else if(this.tipo == TipoRepeticao.tr_while)
			return getWhileValor();
		else {
			String valor = "while(" + this.getCondicao().getValor() + ")\n";
			valor += "\t" + this.comando.getValor() + ";";  
			return valor;
		}	
	}

	private String getWhileValor() {
		String valor = "int "+ this.varControle + ";\n";
			   valor = valor +
					   "while(" + this.varControle + this.terminacao + "){\n";   	
	   				   valor = valor + this.comando.getValor() + "\n";
	   				  valor = valor + this.varControle + this.iteracao + ";\n};";
		return valor;
	}	
	
	private String getForValor() {
		String valor = "for(int " + this.varControle + this.inicializacao + ";" +
									this.varControle + this.terminacao + ";" +
									this.varControle + this.iteracao + ")\n" +
									this.comando.getValor() + "\n";
		return valor;
	}	
		
}
	
	

