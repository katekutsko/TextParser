package by.epam.javatraining.kutsko.task4.model.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.javatraining.kutsko.task4.model.entity.*;
import by.epam.javatraining.kutsko.task4.model.exception.NoSuchTextFragmentException;

/**
 * Provides tools for text analyzing
 * 
 * @author Kutsko Kate 21.03.19
 */
public class TextAnalyzer {

	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}

	public static String getAllWordsOfTextInAlphabeticOrder(Text text) {

		if (text != null) {
			Set<String> wordList = new TreeSet<>((oneWord, anotherWord) -> {
				return oneWord.compareTo(anotherWord);
			});

			text.getAllFragments().forEach((textBlockNumber, textBlock) -> {

				if (textBlock instanceof Paragraph) {

					Paragraph paragraph = (Paragraph) textBlock;
					paragraph.getAllFragments().forEach((sentenceNumber, sentence) -> {

						Sentence currentSentence = (Sentence) sentence;
						currentSentence.getAllFragments().forEach((sentencePartNumber, sentencePart) -> {

							if (sentencePart instanceof Word) {
								wordList.add(sentencePart.toString().toLowerCase());
							}
						});
					});
				}
			});

			StringBuilder builder = new StringBuilder();

			char firstLetter = '0';
			builder.append("\t");

			for (String word : wordList) {

				if (word.charAt(0) != firstLetter) {
					firstLetter = word.charAt(0);
					builder.append("\n\t");
				}

				builder.append(word + " ");
			}
			return builder.toString();
		}

		LOGGER.info("Reference to text was null");
		return "";
	}

	private static String buildString(Map<Integer, Sentence> sentenceList) {

		StringBuilder builder = new StringBuilder();

		sentenceList.forEach((key, sentence) -> {
			builder.append(sentence.toString()).append("\n");
		});
		return builder.toString();
	}

	public static String swapFirstAndLast(Text text) {

		if (text != null) {

			Map<Integer, Sentence> sentenceList = text.getSentences();

			sentenceList.forEach((key, sentence) -> {
				try {

					int lastIndex = sentence.getAmountOFragments() - 1;

					Word firstWord = (Word) sentence.getElement(0); 
					Word lastWord = (Word) sentence.getElement(--lastIndex);

					sentence.replace(0, lastWord);
					sentence.replace(lastIndex, firstWord);
					
					lastWord.setContents(
							lastWord.toString().substring(0, 1).toUpperCase() + lastWord.toString().substring(1));
					firstWord.setContents(firstWord.toString().toLowerCase());

				} catch (NoSuchTextFragmentException e) {
					LOGGER.info("Nonexistent text fragment was addressed");
				}
			});
			return buildString(sentenceList);

		} else {
			LOGGER.info("Reference to text was null");
		}
		return "";
	}

	public static String reverseWordsInSentences(Text text) {

		if (text != null) {

			Map<Integer, Sentence> sentenceList = text.getSentences();
			Map<Integer, Sentence> newSentenceList = new HashMap<>();

			sentenceList.forEach((key, sentence) -> {

				try {

					Map<Integer, SimpleTextUnit> newSentence = new HashMap<>();

					List<Word> wordsList = new ArrayList<>(sentence.getAllWords().values());

					Collections.reverse(wordsList);

					SimpleTextUnit check;

					for (int i = 0, j = 0; i < sentence.getAmountOFragments(); i++) {
						if ((check = (SimpleTextUnit) sentence.getElement(i)) instanceof PunctuationMark) {
							newSentence.put(i, check);
						} else {
							newSentence.put(i, wordsList.get(j));
							j++;
						}

					}
					Word firstWord = (Word) newSentence.get(0);

					Word lastWord = (Word) newSentence.get(newSentence.size() - 2);

					firstWord.setContents(
							firstWord.toString().substring(0, 1).toUpperCase() + firstWord.toString().substring(1));
					lastWord.setContents(lastWord.toString().toLowerCase());
					
					newSentenceList.put(newSentenceList.size(), new Sentence(newSentence));
					
				} catch (NoSuchTextFragmentException e) {
					LOGGER.info("Nonexistent text fragment was addressed");
				}
			});
			return buildString(newSentenceList);
		} else {
			LOGGER.warn("Reference to text was null");
		}
		return "";
	}
}
