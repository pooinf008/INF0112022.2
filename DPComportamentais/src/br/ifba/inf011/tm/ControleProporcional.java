package br.ifba.inf011.tm;

public class ControleProporcional extends ControleTemplate {


	@Override
	protected double getValorAtuacao() {
		double delta = this.diferenca.get(this.diferenca.size()-1); 
		double tempAtuacao = 0;
		if(Math.abs(delta) > 0.1 * setPoint) 
			return tempAtuacao = delta * ganho;
		return tempAtuacao;
	}

	@Override
	protected void logTipoAtuacao() {
		System.err.print("Proporcional\t");
	}

	@Override
	protected double atuar(double tempAtuacao) {
	    if(tempAtuacao > 0)
	    	ambiente.esfriar(tempAtuacao);
	    else
	    	ambiente.aquecer(tempAtuacao);
	    return tempAtuacao;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}


}
