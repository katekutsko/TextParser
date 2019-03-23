package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.CodeBlock;

public class CodeBlockParser extends AbstractParser implements Parser {

	@Override
	public CodeBlock create(String string) {
		return new CodeBlock(string);
	}

}
