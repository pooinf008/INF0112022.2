package br.ifba.edu.aval1.q1.portugol;

import br.ifba.edu.aval1.model.Bloco;
import br.ifba.edu.aval1.model.Comando;

public class PortugolBloco extends Bloco{

	@Override
	public String getValor() {
		String valor = "Inicio\n";
		for(Comando comando : this.comandos)
			valor += "\t" + comando.getValor() + "\n";
		return valor + "Fim";
	}

}
