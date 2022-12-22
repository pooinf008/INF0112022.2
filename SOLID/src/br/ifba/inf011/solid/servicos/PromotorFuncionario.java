package br.ifba.inf011.solid.servicos;

import br.ifba.inf011.solid.exception.RHException;
import br.ifba.inf011.solid.model.Cargo;
import br.ifba.inf011.solid.model.Promovivel;
import br.ifba.inf011.solid.model.Trabalhador;

public class PromotorFuncionario {
	public void promover(Promovivel promovivel) throws RHException {
		//DEVERIA VALIDAR REGRAS DE PROMOCAO
		if(promovivel.getCargo() == Cargo.MENTOR)
			throw new RHException("FIM DE CARREIRA", null);
		Cargo cargoNovo = promovivel.getCargo().proximo();
		promovivel.promover(cargoNovo);
	}
}
