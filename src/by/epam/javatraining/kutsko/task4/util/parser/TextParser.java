package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.Text;
import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;
import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class TextParser extends AbstractParser {

	private static TextParser instance;
	
	{
		nextParser = TextPartParser.getInstance();
	}

//	public Text create(String textAsString) {
//
//		Text text = new Text();
//
//		if (textAsString != null) {
//
//			String[] splittedText = split(textAsString, TEXT_DELIMETER);
//
//			for (String paragraphAsString : splittedText) {
//
//				if (Validator.validateAsParagraph(paragraphAsString)) {
//
//					nextParser = defaultParser;
//					text.add(nextParser.create(paragraphAsString));
//
//				} else if (Validator.validateAsCodeBlock(paragraphAsString)) {
//
//					nextParser = additionalParser;
//					text.add(nextParser.create(paragraphAsString));
//				}
//			}
//		}
//		return text;
//	}
	
	public Text create(String textAsString) {
		
		Text text = new Text();
		
		if (textAsString != null) {	
			
			String[] splittedText = nextParser.split(textAsString, nextParser.getDelimeter());
			
			for (String s : splittedText) {
				text.add(nextParser.create(s));
			}
			
			return text;
		}
		return null;
		
	}

	@Override
	public String getDelimeter() {
		return null;
	}
	
	private TextParser() {}
	
	public static TextParser getInstance() {
		if (instance == null) {
			instance = new TextParser();
		}
		return instance;
	}

}
