package br.ifba.inf011.criacional.fm.model.exception;

public class AppException extends Exception {
	private String message;
	
	public AppException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return "Erro: " + this.getMessage();
	}
	
	
}
