package br.ifba.edu.aval1.q1.C;

import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Comando;

public class CBloco extends Bloco{

	@Override
	public String getValor() {
		String valor = "{\n";
		for(Comando comando : this.comandos)
			valor += "\t" + comando.getValor() + "\n";
		return valor + "}";
	}

}
