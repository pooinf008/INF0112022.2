package br.ifba.inf011.criacional.fm.model.termometro;

import java.lang.reflect.InvocationTargetException;

import br.ifba.inf011.criacional.fm.model.exception.AppException;

public abstract class TermometroFactory {
	
		public double temperatura;
		public TermometroFactory factory;
		
		public TermometroFactory() {
			super();
			this.factory = null;
		}

		protected abstract Termometro criaTermometro();

		public Termometro getTermometro(String conf) throws AppException {
			Termometro termometro = this.criaTermometro();
			termometro.config(conf);
			return termometro;
		}	
		
		public static Termometro getTermometro(TipoTermometro tipo, String conf) throws AppException {
			TermometroFactory factory = TermometroFactory.getFactory(tipo.getFactoryName());
			Termometro termometro = factory.getTermometro(conf);
			return termometro;			
		}
		
		public static TermometroFactory getFactory(String nomeFactory) throws AppException {
			
			try {
				TermometroFactory factory = (TermometroFactory) Class.forName(nomeFactory).getConstructor().newInstance();
				return factory;
			} catch (Exception e) {
				throw new AppException("Factory Inexistente");				
			}
			
		}
		
}
