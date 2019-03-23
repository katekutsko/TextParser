package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.PunctuationMark;

public class PunctuationMarkParser extends AbstractParser {

	@Override
	public PunctuationMark create(String string) {
		return new PunctuationMark(string);
	}

}
