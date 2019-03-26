package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.CodeBlock;
import by.epam.javatraining.kutsko.task4.model.entity.Paragraph;
import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;
import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class TextPartParser extends AbstractParser {

	private static TextPartParser instance;
	private final static String TEXT_BLOCK_DELIMETER = "\\n\\n";
	
	
	{
		nextParser = SentenceParser.getInstance();
	}
	
	private TextPartParser() {}
	
	@Override 
	public String[] split(String text, String delimeter) {
		
		if (text != null) {
			return text.split(delimeter);
		}
		return new String[0];
	}
	
	@Override
	public TextUnit create(String text) {
		
		if (text != null) {
			if (Validator.validateAsParagraph(text)) {
				
				Paragraph paragraph = new Paragraph();
				String[] splittedParagraph = nextParser.split(text, nextParser.getDelimeter());
	
				for (String s : splittedParagraph) {
					paragraph.add(nextParser.create(s));
				}

				return paragraph;
				
			} else if (Validator.validateAsCodeBlock(text)) {
				return new CodeBlock(text);
			}
		}
		return null;
	}

	@Override
	public String getDelimeter() {
		return TEXT_BLOCK_DELIMETER;
	}
	
	public static TextPartParser getInstance() {
		if (instance == null) {
			instance = new TextPartParser();
		}
		return instance;
	}

}
