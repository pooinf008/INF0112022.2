package br.ifba.inf011.criacional.fm.model.atuadores;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.fm.model.exception.AppException;

public abstract class AtuadorFactory {
	
		public double temperatura;
		public AtuadorFactory factory;
		
		public AtuadorFactory() {
			super();
			this.factory = null;
		}

		protected abstract Atuador criaAtuador();

		public Atuador getAtuador(String conf) throws AppException {
			Atuador atuador = this.criaAtuador();
			atuador.config(conf);
			return atuador;
		}	
		
		public static AtuadorFactory getFactory(String nomeFactory) throws AppException {
			
			try {
				AtuadorFactory factory = (AtuadorFactory) Class.forName(nomeFactory).getConstructor().newInstance();
				return factory;
			} catch (Exception e) {
				throw new AppException("Factory Inexistente");				
			}
			
		}
		
}
