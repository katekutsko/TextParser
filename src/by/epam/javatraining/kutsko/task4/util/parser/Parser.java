package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;

/**
 * Provides an implementing class with ability to parse text data
 */
public interface Parser <T extends TextUnit> {
	
	String[] split(String text, String delimeter);
	
	T create(String string);
	
	String getDelimeter();
}
