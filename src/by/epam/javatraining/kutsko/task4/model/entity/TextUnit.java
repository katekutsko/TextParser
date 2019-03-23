package by.epam.javatraining.kutsko.task4.model.entity;

public abstract class TextUnit implements Cloneable {
	
	public abstract void clear();
	
	public abstract String toString();
	
	public abstract boolean isEmpty();
	
	@Override
	public abstract TextUnit clone();
	
}
