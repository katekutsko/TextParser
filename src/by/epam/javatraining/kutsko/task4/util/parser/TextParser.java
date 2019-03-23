package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.Text;
import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;
import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class TextParser extends AbstractParser {

	private final Parser<TextUnit> defaultParser;
	private final Parser<TextUnit> additionalParser;

	{
		defaultParser = new ParagraphParser();
		additionalParser = new CodeBlockParser();
		nextParser = defaultParser;
	}

	public Text create(String textAsString) {

		Text text = new Text();

		if (textAsString != null) {

			String[] splittedText = split(textAsString, Parser.TEXT_DELIMETER);
			
			for (String paragraphAsString : splittedText) {
				
				if (Validator.validateAsParagraph(paragraphAsString)) {
						
						nextParser = defaultParser; 
						text.add(nextParser.create(paragraphAsString));

				} else if (Validator.validateAsCodeBlock(paragraphAsString)) {
					
					nextParser = additionalParser;
					text.add(nextParser.create(paragraphAsString));
				}
			}
		}
		return text;
	}

}
