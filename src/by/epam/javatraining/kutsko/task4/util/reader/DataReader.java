package by.epam.javatraining.kutsko.task4.util.reader;

import java.io.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.javatraining.kutsko.task4.model.exception.CorruptParameterReferenceException;

public class DataReader {

	public static final String LINE_SEPARATOR = "\n";
	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}

	public static String readFromFile(String path) throws FileNotFoundException, IOException {

		StringBuilder text = new StringBuilder();
		String line;
		if (path != null) {
			try (BufferedReader fis = new BufferedReader(new FileReader(path))) {

				while ((line = fis.readLine()) != null) {
					text.append(line).append(LINE_SEPARATOR);
				}
				text.deleteCharAt(text.length() - 1);
			}
		}
		
		return text.toString();
	}

}
