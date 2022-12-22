package br.ifba.inf011.solid;

import java.math.BigDecimal;

import br.ifba.inf011.solid.exception.RHException;
import br.ifba.inf011.solid.model.Funcionario;
import br.ifba.inf011.solid.model.Terceiro;
import br.ifba.inf011.solid.servicos.PromotorFuncionario;
import br.ifba.inf011.solid.servicos.ReajustadorSalario;
import br.ifba.inf011.solid.servicos.regras.RegraIndiceMaximo;
import br.ifba.inf011.solid.servicos.regras.RegraIndiceMinimo;

public class App {
	
	public void run() {

		
		
		ReajustadorSalario reajustador2 = new ReajustadorSalario();
		reajustador2.addRegra(new RegraIndiceMinimo());
		
		
		PromotorFuncionario promotor = new PromotorFuncionario();
		ReajustadorSalario reajustador = new ReajustadorSalario();
		reajustador.addRegra(new RegraIndiceMinimo());
		reajustador.addRegra(new RegraIndiceMaximo());
		
		Terceiro bob = new Terceiro("Uncle Bob", "002", "000000002", new BigDecimal(100));
		Funcionario gamma = new Funcionario("Gamma", "001", "000000001", new BigDecimal(100));
		System.out.println(gamma);
		try {
			reajustador.reajustar(gamma, new BigDecimal(0.15));
			
		} catch (RHException e) {
			System.out.println("Não foi possivel reajustar salario. erro: " + e.toString());			
		}
		System.out.println(gamma);
		System.out.println(bob);

		try {
			reajustador.reajustar(bob, new BigDecimal(0.15));
			
		} catch (RHException e) {
			System.out.println("Não foi possivel reajustar salario. erro: " + e.toString());			
		}		
		
		System.out.println(bob);
		
		try {
			promotor.promover(gamma);
		} catch (RHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(gamma);
		
		
	}
	
	
	public static void main(String[] args) {
		(new App()).run();
	}

}
