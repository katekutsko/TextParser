package by.epam.javatraining.kutsko.task4.model.entity;

import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class PunctuationMark extends SimpleTextUnit implements Cloneable {
	
	public PunctuationMark(String contents) {
		super();
		if (Validator.validateAsPunctuationMark(contents)) {
			setContents(contents);
		}
	}
	
	public PunctuationMark() {
		
	}
	
	@Override
	public PunctuationMark clone() {
		return new PunctuationMark(contents);
	}
}
