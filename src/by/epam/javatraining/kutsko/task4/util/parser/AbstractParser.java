package by.epam.javatraining.kutsko.task4.util.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;

public abstract class AbstractParser implements Parser {

	protected Parser nextParser;

	public String[] split(String textElement, String delimeter) {
		
		Pattern pattern = Pattern.compile(delimeter);
		Matcher matcher = pattern.matcher(textElement);
		List<String> sentenceFragments = new ArrayList<String>();

		while (matcher.find()) {
			sentenceFragments.add(matcher.group());
		}

		return sentenceFragments.toArray(new String[sentenceFragments.size()]);

	}

	public void setNextParser(Parser parser) {
		nextParser = parser;
	}

	public Parser getNextParser() {
		return nextParser;
	}

	abstract public TextUnit create(String text);
}
