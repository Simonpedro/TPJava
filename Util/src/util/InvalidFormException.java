package util;

public class InvalidFormException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidFormException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
