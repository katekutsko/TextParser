package by.epam.javatraining.kutsko.task4.model.entity;

public class CodeBlock extends SimpleTextUnit{
	
	public CodeBlock(String line) {
		super(line);
	}
	
	public CodeBlock() {
		super();
	}

	@Override
	public TextUnit clone() {
		return new CodeBlock(contents);
	}
	
}
