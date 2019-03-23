package by.epam.javatraining.kutsko.task4.model.entity;

public class PunctuationMark extends SimpleTextUnit implements Cloneable {
	
	public PunctuationMark(String contents) {
		super(contents);
	}
	
	public PunctuationMark() {
		
	}
	
	@Override
	public PunctuationMark clone() {
		return new PunctuationMark(contents);
	}
}
