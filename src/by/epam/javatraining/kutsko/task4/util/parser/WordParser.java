package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.Word;

public class WordParser extends AbstractParser {

	@Override
	public Word create(String string) {
		return new Word(string);
	}

}
