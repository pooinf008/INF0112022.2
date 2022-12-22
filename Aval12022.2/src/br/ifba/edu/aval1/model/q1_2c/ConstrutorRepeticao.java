package br.ifba.edu.aval1.model.q1_2c;

import java.io.PrintStream;

import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.TipoRepeticao;
import br.ifba.edu.aval1.q1.C.CBloco;
import br.ifba.edu.aval1.q1.C.CRepeticao;

public class ConstrutorRepeticao implements Construtor{

	
	private TipoRepeticao tipo;
	private String varControle;
	private String inicializacao;
	private String terminacao;
	private String iteracao;	
	private Comando comando;
	
	public ConstrutorRepeticao() {
		this.reset();
	}
	
	@Override
	public ConstrutorRepeticao reset() {
		this.tipo = TipoRepeticao.tr_for;
		this.varControle = "iCont";
		this.inicializacao = "=0";
		this.terminacao = null;
		this.iteracao = "++";
		this.comando = new CBloco();
		return this;
	}

	@Override
	public Construtor withControl(String var) {
		this.varControle = var;
		return this;
	}

	@Override
	public Construtor tipo(TipoRepeticao tipo) {
		this.tipo = tipo;
		return this;
	}

	@Override
	public Construtor withInit(String inicializacao) {
		this.inicializacao = inicializacao;
		return this;
	}

	@Override
	public Construtor withIter(String iteracao) {
		this.iteracao = iteracao;
		return this;
	}
	
	@Override
	public Construtor withBloco(Comando comando) {
		this.comando = comando;
		return this;
	}	
	
	public CRepeticao build(String terminacao) {
		return new CRepeticao(this.tipo, this.varControle,
							  this.inicializacao, this.iteracao, 
							  terminacao, this.comando);
		
	}


}
