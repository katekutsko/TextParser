package by.epam.javatraining.kutsko.task4.model.exception;

public class InvalidFilePathException extends TextParserTechnicalException {

	public InvalidFilePathException() {
		super();
	}

	public InvalidFilePathException(String arg) {
		super(arg);
	}

	public InvalidFilePathException(Throwable arg) {
		super(arg);
	}

	public InvalidFilePathException(String arg, Throwable cause) {
		super(arg, cause);
	}

}
