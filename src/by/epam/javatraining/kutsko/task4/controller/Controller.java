package by.epam.javatraining.kutsko.task4.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.javatraining.kutsko.task4.model.entity.Text;
import by.epam.javatraining.kutsko.task4.model.exception.FailedReadingFileException;
import by.epam.javatraining.kutsko.task4.model.exception.InvalidFilePathException;
import by.epam.javatraining.kutsko.task4.model.logic.TextAnalyzer;
import by.epam.javatraining.kutsko.task4.util.parser.AbstractParser;
import by.epam.javatraining.kutsko.task4.util.parser.TextParser;
import by.epam.javatraining.kutsko.task4.util.reader.DataReader;

public class Controller {

	private static final String FILE_PATH = "data.txt";
	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}

	public static void main(String[] args) {

		String wholeText = "";
		
		try {
			
			wholeText = DataReader.readFromFile(FILE_PATH);

		} catch (InvalidFilePathException ex) {
			LOGGER.error(ex.toString() + ": File was not found");

		} catch (FailedReadingFileException e) {
			LOGGER.error(e.toString() + ": Failed to read properly");
		}
		AbstractParser textParser = TextParser.getInstance();
		//textParser.setNextParser(new SentenceParser());
		Text text = (Text) textParser.create(wholeText);
		//System.out.println(text);
		System.out.println(TextAnalyzer.reverseWordsInSentences(text));
	}

}
