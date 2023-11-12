package br.ifba.inf011.modelo;

import java.util.ArrayList;
import java.util.List;

public class ObraDB {
	
	private static ObraDB obraDB;
	
	public static ObraDB instance() {
		if(ObraDB.obraDB == null)
			ObraDB.obraDB  = new ObraDB();
		return ObraDB.obraDB;
	}
	
	private List<Obra> obras;
	
	private ObraDB() {
		this.obras = new ArrayList<Obra>();
		this.populate();
	}
	
	private void populate() {
		
		this.obras.add(new Livro("Rinha de galos", 
				 2021, 4.6, "Moinhos",
				 "Portugu�s", "Mar�a Fernanda Ampuero", 112));			
		
		this.obras.add(new Livro("Solu��o de Dois Estados", 
								 2020, 4.3, "Companhia das Letras",
								 "Portugu�s", "Michel Laub", 248));
		
		this.obras.add(new Album("What's Going On", 
				 1971, 4.7, "Motown/Tamla",
				 "United Sound Studios", "Marvin Gaye", 2104));			
		
		this.obras.add(new Livro("Discurso sobre o Colonialismo", 
				 2020, 4.9, "Veneta",
				 "Portugu�s", "Aim� C�saire", 136));	
		
		this.obras.add(new Album("Acabou Chorare", 
				 				 1972, 4.9, "Som Livre",
				 				 "Somil", "Novos Baianos", 2160));			
		
	}

	public List<Obra> getObras() {
		return this.obras;
	}

}
