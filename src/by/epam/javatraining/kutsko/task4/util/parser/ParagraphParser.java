package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.Paragraph;
import by.epam.javatraining.kutsko.task4.model.entity.Sentence;
import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;

public class ParagraphParser extends AbstractParser {

	{
		nextParser = new SentenceParser();
	}

	@Override
	public Paragraph create(String string) {

		Paragraph paragraph = new Paragraph();

		if (string != null) {

			String[] sentences = split(string, Parser.PARAGRAPH_DELIMETER);
			
			for (String sentence : sentences) {
				
				TextUnit newSentence = nextParser.create(sentence);
				
				if (newSentence != null && !newSentence.isEmpty()) {
					paragraph.add(newSentence);
				}
			}
		}
		return paragraph;
	}

}
