package exceptions;

public class CustomerNotFoundException extends RuntimeException {
    
<<<<<<< HEAD
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
=======
    public CustomerNotFoundException(String message) {
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
        super(message);
    }
    
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
