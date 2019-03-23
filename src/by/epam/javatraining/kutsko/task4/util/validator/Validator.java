package by.epam.javatraining.kutsko.task4.util.validator;

import java.util.regex.Pattern;

public class Validator {

	public static final String PARAGRAPH_REGEXP = "\\t[A-Z]+[\\w+\\p{Punct}+\\s+]+[.:]";
	public static final String PUNCTUATION_MARK_REGEXP = "\\p{Punct}+|\\t";
	public static final String CODE_BLOCK_REGEXP = "(^(.*\\n?).*\\{(?s).*\\})|(^\\s?.+ = .+;\\n*)+";
	private static Pattern paragraphPattern;
	private static Pattern punctuationPattern;
	private static Pattern codeBlockPattern;

	static {

		paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
		punctuationPattern = Pattern.compile(PUNCTUATION_MARK_REGEXP);
		codeBlockPattern = Pattern.compile(CODE_BLOCK_REGEXP);
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
}