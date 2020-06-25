package br.com.tokiomarine.seguradora.avaliacao.controller.handle;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.tokiomarine.seguradora.avaliacao.exception.ApiResponseError;
import br.com.tokiomarine.seguradora.avaliacao.exception.ApiResponseFieldError;
import br.com.tokiomarine.seguradora.avaliacao.exception.RecursoNaoEncontradoException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ApiResponseError> recursoNaoEncontradoResponse(RecursoNaoEncontradoException ex, WebRequest request) {
		ApiResponseError apiResponse = new ApiResponseError(ex.getMessage(), LocalDateTime.now());		
		return new ResponseEntity<ApiResponseError>(apiResponse, new HttpHeaders() ,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> campos = new LinkedHashMap<>();
		ex.getBindingResult().getAllErrors().forEach((e) -> {
			ObjectError objErro = e;
			String campoErro = ((FieldError)objErro).getField();
			String mensagemCampoErro = objErro.getDefaultMessage();
			campos.put(campoErro, mensagemCampoErro);
		});
		ApiResponseFieldError apiResponse = new ApiResponseFieldError("Alguns campos estão invalidos", LocalDateTime.now(), campos);
		return new ResponseEntity<Object>(apiResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApiResponseError> ErroInterno(Exception ex, WebRequest request) {
		ApiResponseError apiResponseError = new ApiResponseError("Ocorreu um erro interno", LocalDateTime.now());
		return new ResponseEntity<ApiResponseError>(apiResponseError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
