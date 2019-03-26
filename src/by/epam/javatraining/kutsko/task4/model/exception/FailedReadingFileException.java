package by.epam.javatraining.kutsko.task4.model.exception;

public class FailedReadingFileException extends TextParserTechnicalException {

	public FailedReadingFileException() {
	}

	public FailedReadingFileException(String message) {
		super(message);
	}

	public FailedReadingFileException(Throwable cause) {
		super(cause);
	}

	public FailedReadingFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
