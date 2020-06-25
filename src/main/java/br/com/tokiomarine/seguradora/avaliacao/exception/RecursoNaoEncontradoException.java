package br.com.tokiomarine.seguradora.avaliacao.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524809166404844265L;

	public RecursoNaoEncontradoException() {}

	public RecursoNaoEncontradoException(String message) {
		super(message);
	}

	public RecursoNaoEncontradoException(Throwable cause) {
		super(cause);
	}

	public RecursoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

}
