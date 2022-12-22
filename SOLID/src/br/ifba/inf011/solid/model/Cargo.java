package br.ifba.inf011.solid.model;

public enum Cargo {
	JUNIOR {
		@Override
		public Cargo proximo() {
			return PLENO;
		}
	}, PLENO {
		@Override
		public Cargo proximo() {
			return SENIOR;
		}
	}, SENIOR {
		@Override
		public Cargo proximo() {
			return MENTOR;
		}
	}, MENTOR {
		@Override
		public Cargo proximo() {
			return MENTOR;
		}
	};

	public abstract Cargo proximo();
}
