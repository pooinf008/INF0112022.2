package br.ifba.edu.aval1.model.q1_2c;

import java.io.PrintStream;

import br.ifba.edu.aval1.model.Comando;
import br.ifba.edu.aval1.model.TipoRepeticao;
import br.ifba.edu.aval1.q1.C.CRepeticao;

public interface Construtor {
	public Construtor reset();
	public Construtor withControl(String var);
	public Construtor tipo(TipoRepeticao tipo);
	public Construtor withInit(String inicializacao);
	public Construtor withIter(String iteracao);
	public Construtor withBloco(Comando comando);
	public CRepeticao build(String string);
}

