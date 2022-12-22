package br.ifba.inf011.solid.servicos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.ifba.inf011.solid.exception.RHException;
import br.ifba.inf011.solid.model.Funcionario;
import br.ifba.inf011.solid.model.Reajustavel;
import br.ifba.inf011.solid.model.Trabalhador;
import br.ifba.inf011.solid.servicos.regras.Regra;

public class ReajustadorSalario {
	
	private List<Regra> regras;
	
	public ReajustadorSalario() {
		this.regras = new LinkedList<Regra>();
	}
	
	public void addRegra(Regra regra) {
		this.regras.add(regra);
	}
	
	public void reajustar(Reajustavel reajustavel, BigDecimal indice) throws RHException {
		for(Regra r : this.regras)
			r.validar(reajustavel, indice);
		reajustavel.reajustar(indice);
	}
}
