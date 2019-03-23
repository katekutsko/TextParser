package by.epam.javatraining.kutsko.task4.model.entity;

public class Word extends SimpleTextUnit implements Cloneable {
	
	public Word(String contents) {
		super(contents);
	}
	
	public Word() {
		super();
	}
	
	@Override
	public Word clone() {
		return new Word(contents);
	}
}
