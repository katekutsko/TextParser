package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;

/**
 * Provides an implementing class with ability to parse text data
 */
public interface Parser <T extends TextUnit> {

	public static final String TEXT_DELIMETER = "^(\\n\\n)";
	public static final String PARAGRAPH_DELIMETER = "\\. ";
	public static final String SENTENCE_REGEXP = "[.]{3}|(=|-|/|\\*)?=|[\\p{Punct}]|[\\w]+";
	
	String[] split(String text, String delimeter);
	
	T create(String string);
	
	String getDelimeter();
}
