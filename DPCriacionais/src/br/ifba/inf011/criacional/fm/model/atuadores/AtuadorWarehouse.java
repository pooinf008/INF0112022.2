package br.ifba.inf011.criacional.fm.model.atuadores;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.fm.model.exception.AppException;

public class AtuadorWarehouse {
	
		private AtuadorCreator creator;
		
		public AtuadorWarehouse(AtuadorCreator creator) {
			this.registerCreator(creator);
		}
		
		public AtuadorWarehouse(String creator) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
			this.registerCreator(creator);
		}
		
		public void registerCreator(AtuadorCreator creator) {
			this.creator = creator; 
		}
		
		public void registerCreator(String creator) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
			this.registerCreator((AtuadorCreator) Class.forName(creator).getConstructor().newInstance()); 
		}
		
		public Atuador getAtuador(String conf) throws AppException {
			Atuador atuador = this.creator.criaAtuador();
			atuador.config(conf);
			return atuador;			
		}
	
}
