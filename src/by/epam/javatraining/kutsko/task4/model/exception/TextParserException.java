package by.epam.javatraining.kutsko.task4.model.exception;

public class TextParserException extends Exception {

	public TextParserException() {
	}

	public TextParserException(String message) {
		super(message);
	}

	public TextParserException(Throwable cause) {
		super(cause);
	}

	public TextParserException(String message, Throwable cause) {
		super(message, cause);
	}
}
