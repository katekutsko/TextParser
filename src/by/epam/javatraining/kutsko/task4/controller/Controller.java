package by.epam.javatraining.kutsko.task4.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.javatraining.kutsko.task4.model.entity.Text;
import by.epam.javatraining.kutsko.task4.model.exception.CorruptParameterReferenceException;
import by.epam.javatraining.kutsko.task4.model.logic.TextAnalyzer;
import by.epam.javatraining.kutsko.task4.util.parser.Parser;
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

		} catch (FileNotFoundException ex) {
			LOGGER.error(ex.toString() + ": File was not found");

		} catch (IOException e) {
			LOGGER.error(e.toString() + ": Failed to read properly");
		}
		Parser<Text> textParser = new TextParser();
		Text text = (Text) textParser.create(wholeText);
		System.out.println(TextAnalyzer.reverseSentences(text));
	}

}
