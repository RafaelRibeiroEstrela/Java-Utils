package rafaelribeiroestrela.com.github.utilidades.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import rafaelribeiroestrela.com.github.utilidades.exceptions.ApiException;
import rafaelribeiroestrela.com.github.utilidades.exceptions.StandardError;

@ControllerAdvice
public class ExceptionResource {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<StandardError> exceptionDefault(ApiException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTime(LocalDateTime.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
