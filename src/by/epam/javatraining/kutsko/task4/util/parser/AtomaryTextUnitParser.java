package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.PunctuationMark;
import by.epam.javatraining.kutsko.task4.model.entity.SimpleTextUnit;
import by.epam.javatraining.kutsko.task4.model.entity.Word;
import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class AtomaryTextUnitParser extends AbstractParser {

	@Override
	public SimpleTextUnit create(String string) {
		if (string != null) {
			if (Validator.validateAsWord(string)) {
				return new Word(string);
			} else if (Validator.validateAsPunctuationMark(string)) {
				return new PunctuationMark(string);
			}
		}
		return null;
	}

}
