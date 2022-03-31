package rafaelribeiroestrela.com.github.utilidades.services.exceptions;

public class ApiException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ApiException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ApiException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
