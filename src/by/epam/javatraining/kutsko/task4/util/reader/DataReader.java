package by.epam.javatraining.kutsko.task4.util.reader;

import java.io.*;

import by.epam.javatraining.kutsko.task4.model.exception.FailedReadingFileException;
import by.epam.javatraining.kutsko.task4.model.exception.InvalidFilePathException;

public class DataReader {

	public static final String LINE_SEPARATOR = "\n";

	public static String readFromFile(String path) throws InvalidFilePathException, FailedReadingFileException {

		StringBuilder text = new StringBuilder();
		String line;
		if (path != null) {
			try (BufferedReader fis = new BufferedReader(new FileReader(path))) {

				while ((line = fis.readLine()) != null) {
					text.append(line).append(LINE_SEPARATOR);
				}
				text.deleteCharAt(text.length() - 1);
			} catch (FileNotFoundException e) {
				throw new InvalidFilePathException(e);
			} catch (IOException e) {
				throw new FailedReadingFileException(e);
			}
			return text.toString();
		}
		throw new InvalidFilePathException();
	}

}
