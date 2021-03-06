package by.epam.javatraining.kutsko.task4.model.entity;

import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class Word extends SimpleTextUnit implements Cloneable {

	public Word(String contents) {
		super();
		if (Validator.validateAsWord(contents)) {
			setContents(contents);
		}
	}

	public Word() {
		super();
	}

	public Word(Word word) {
		super();
		if (word != null && word.contents != null) {
			contents = word.contents;
		}
	}

	@Override
	public Word clone() {
		return new Word(contents);
	}
}
