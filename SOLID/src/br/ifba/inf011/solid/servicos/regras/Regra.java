package br.ifba.inf011.solid.servicos.regras;

import java.math.BigDecimal;

import br.ifba.inf011.solid.exception.RHException;
import br.ifba.inf011.solid.model.Funcionario;
import br.ifba.inf011.solid.model.Reajustavel;
import br.ifba.inf011.solid.model.Trabalhador;

public interface Regra {
	public void validar(Reajustavel reajustavel, BigDecimal indice) throws RHException;
}
