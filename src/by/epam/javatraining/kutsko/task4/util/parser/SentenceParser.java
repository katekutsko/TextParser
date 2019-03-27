package by.epam.javatraining.kutsko.task4.util.parser;

import by.epam.javatraining.kutsko.task4.model.entity.Sentence;
import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class SentenceParser extends AbstractParser {

	private static SentenceParser instance;
	private final static String SENTENCE_DELIMETER = "[A-Z][\\w\\d\\p{Space}\\p{Punct}&&[^.:\n]]+\\S[.:] ?";

	{
		nextParser = new AtomaryTextUnitParser();
	}

	private SentenceParser() {}
	
	@Override
	public Sentence create(String sentence) {

		Sentence newSentence = null;
		
		if (sentence != null && Validator.validateAsSentence(sentence)) {

			newSentence = new Sentence();
			
			String[] splittedSentence = nextParser.split(sentence, nextParser.getDelimeter());

			for (String sentenceFragment : splittedSentence) {
				newSentence.add(nextParser.create(sentenceFragment));
			}
		}
		return newSentence;
	}

	@Override
	public String getDelimeter() {
		return SENTENCE_DELIMETER;
	}

	public static SentenceParser getInstance() {
		if (instance == null) {
			instance = new SentenceParser();
		}
		return instance;
	}
}
