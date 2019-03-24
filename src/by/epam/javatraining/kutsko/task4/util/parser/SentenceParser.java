package by.epam.javatraining.kutsko.task4.util.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.javatraining.kutsko.task4.model.entity.Sentence;
import by.epam.javatraining.kutsko.task4.model.entity.SimpleTextUnit;
import by.epam.javatraining.kutsko.task4.model.entity.TextUnit;
import by.epam.javatraining.kutsko.task4.util.validator.Validator;

public class SentenceParser extends AbstractParser {

	private Parser<TextUnit> wordParser = new WordParser();
	private Parser<TextUnit> punctuationMarkParser = new PunctuationMarkParser();

	@Override
	public Sentence create(String sentence) {

		Sentence newSentence = new Sentence();
		
		if (sentence != null && Validator.validateAsSentence(sentence)) {
	
			Pattern pattern = Pattern.compile(SENTENCE_DELIMETER);
			Matcher matcher = pattern.matcher(sentence);
			List<String> sentenceFragments = new ArrayList<String>();

			while (matcher.find()) {
				sentenceFragments.add(matcher.group());
			}

			for (String sentenceFragment : sentenceFragments) {

				if (Validator.validateAsPunctuationMark(sentenceFragment)) {

					if (!newSentence.isEmpty()) {

						nextParser = punctuationMarkParser;
						SimpleTextUnit unit = (SimpleTextUnit) nextParser.create(sentenceFragment);
						newSentence.add(unit);
					}

				} else {

					nextParser = wordParser;
					newSentence.add(nextParser.create(sentenceFragment));
				}

			}
		}
		return newSentence;
	}

}
