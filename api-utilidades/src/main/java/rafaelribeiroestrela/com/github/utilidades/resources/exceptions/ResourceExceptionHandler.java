package rafaelribeiroestrela.com.github.utilidades.resources.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import rafaelribeiroestrela.com.github.utilidades.services.exceptions.ApiException;

public class ResourceExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<StandardError> CustomError(ApiException e, HttpServletRequest request) {
		
		StandardError err = new StandardError();
		err.setTime(LocalDateTime.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
