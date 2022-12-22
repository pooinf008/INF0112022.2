package br.ifba.inf011.criacional.fm.model.termometro;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.fm.model.exception.AppException;

public class TermometroWarehouse {
	
		public TermometroCreator creator;
		
		public TermometroWarehouse(TermometroCreator creator) {
			this.registerCreator(creator);
		}
		
		public TermometroWarehouse(String creator) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
			this.registerCreator(creator);
		}		
		
		
		private void registerCreator(TermometroCreator creator) {
			this.creator = creator; 
		}
		
		private void registerCreator(String creator) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
			this.registerCreator((TermometroCreator) Class.forName(creator).getConstructor().newInstance()); 
		}
		
		public Termometro getTermometro(String conf) throws AppException {
			Termometro termometro = creator.criaTermometro();
			termometro.config(conf);
			return termometro;			
		}
	
}
