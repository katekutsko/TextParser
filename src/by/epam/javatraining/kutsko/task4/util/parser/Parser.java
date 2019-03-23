package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;

/**
 * Provides an implementing class with ability to parse text data
 */
public interface Parser <T extends TextUnit> {

	public static final String TEXT_DELIMETER = "\\n\\n";
	public static final String PARAGRAPH_DELIMETER = "\\. ";
	public static final String SENTENCE_DELIMETER = "[.]{3}|(=|-|/|\\*)?=|[\\p{Punct}]|[\\w]+|\\t";
	
	String[] split(String textElement, String delimeter);
	
	void setNextParser(Parser<? extends TextUnit> parser);
	
	Parser<? extends TextUnit> getNextParser();
	
	T create(String string);
	
}
