package by.epam.javatraining.kutsko.task4.util.validator;

import java.util.regex.Pattern;

public class Validator {

	public static final String PARAGRAPH_REGEXP = "\\t[A-Z]+[\\w+\\p{Punct}+\\s+]+[.:]";
	public static final String PUNCTUATION_MARK_REGEXP = "\\p{Punct}+|\\t";
	public static final String CODE_BLOCK_REGEXP = "(^(.*\\n?).*\\{(?s).*\\})|(^\\s?.+ = .+;\\n*)+";
	public static final String SENTENCE_REGEXP = "^[A-Z0-9]+[\\w\\s]+[\\p{Punct}]?$";
	public static final String WORD_REGEXP = "\\w+";
	private static Pattern paragraphPattern;
	private static Pattern punctuationPattern;
	private static Pattern codeBlockPattern;
	private static Pattern wordPattern;
	private static Pattern sentencePattern;

	static {

		paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
		punctuationPattern = Pattern.compile(PUNCTUATION_MARK_REGEXP);
		codeBlockPattern = Pattern.compile(CODE_BLOCK_REGEXP);
		wordPattern = Pattern.compile(WORD_REGEXP);
		sentencePattern = Pattern.compile(SENTENCE_REGEXP);
	}

	public static boolean validateAsParagraph(String paragraph) {
		if (paragraph != null) {
			return paragraphPattern.matcher(paragraph).matches();
		}
		return false;
	}

	public static boolean validateAsPunctuationMark(String punctuationMark) {
		if (punctuationMark != null) {
			return punctuationPattern.matcher(punctuationMark).matches();
		}
		return false;
	}
	
	public static boolean validateAsCodeBlock(String code) {
		if (code != null) {
			return codeBlockPattern.matcher(code).matches();
		}
		return false;
	}
	
	public static boolean validateAsWord(String word) {
		if (word != null) {
			return wordPattern.matcher(word).matches();
		}
		return false;
	}
	
	public static boolean validateAsSentence(String sentence) {
		if (sentence != null) {
			return sentencePattern.matcher(sentence).matches();
		}
		return false;
	}
}