package br.ifba.inf011.model.bridge;

public class ConsoleMedium implements Medium{

	@Override
	public void prepare() {
		
	}

	@Override
	public void write(String string) {
		System.out.println(string);
	}

	@Override
	public void close() {
	}

}
