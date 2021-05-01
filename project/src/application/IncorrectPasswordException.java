package application;

public class IncorrectPasswordException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	String errorMessage;

	public IncorrectPasswordException(String errorMessage) {

		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "MyException[" + errorMessage + "]";
	}
}
