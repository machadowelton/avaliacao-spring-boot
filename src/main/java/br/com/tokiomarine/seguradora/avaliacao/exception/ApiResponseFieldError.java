package br.com.tokiomarine.seguradora.avaliacao.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ApiResponseFieldError extends ApiResponseError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2324152437775918575L;
	
	private Map<String, String> campos = new HashMap<String, String>();

	public ApiResponseFieldError() {
		// TODO Auto-generated constructor stub
	}

	public ApiResponseFieldError(String mensagem, LocalDateTime timestamp) {
		super(mensagem, timestamp);
		// TODO Auto-generated constructor stub
	}

	public ApiResponseFieldError(String mensagem, LocalDateTime timestamp, Map<String, String> campos) {
		super(mensagem, timestamp);
		this.campos = campos;
	}

	public Map<String, String> getCampos() {
		return campos;
	}

	public void setCampos(Map<String, String> campos) {
		this.campos = campos;
	}		

}
