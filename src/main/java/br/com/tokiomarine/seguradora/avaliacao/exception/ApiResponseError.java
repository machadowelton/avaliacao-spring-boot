package br.com.tokiomarine.seguradora.avaliacao.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ApiResponseError implements Serializable{

	private static final long serialVersionUID = -6647778103490391104L;
	
	
	private String mensagem;
	
	private LocalDateTime timestamp = LocalDateTime.now();
	
	public ApiResponseError() {
		// TODO Auto-generated constructor stub
	}

	public ApiResponseError(String mensagem, LocalDateTime timestamp) {
		super();
		this.mensagem = mensagem;
		this.timestamp = timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}	

}
