package by.epam.javatraining.kutsko.task4.util.parser;

public abstract class AbstractParser implements Parser {
	
	protected Parser nextParser;
	
	@Override
	public String[] split(String textElement, String delimeter) {
		if (textElement != null) {
			return textElement.split(delimeter);
		}
		return new String[0];
	}

	@Override
	public void setNextParser(Parser parser) {
		nextParser = parser;
	}

	@Override
	public Parser getNextParser() {
		return nextParser;
	}

	
}
