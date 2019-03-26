package by.epam.javatraining.kutsko.task4.model.exception;

public class TextParserTechnicalException extends TextParserException {

	public TextParserTechnicalException() {
	}

	public TextParserTechnicalException(String message) {
		super(message);
	}

	public TextParserTechnicalException(Throwable cause) {
		super(cause);
	}

	public TextParserTechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

}
