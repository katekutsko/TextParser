package by.epam.javatraining.kutsko.task4.model.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import by.epam.javatraining.kutsko.task4.model.entity.*;
import by.epam.javatraining.kutsko.task4.model.exception.CorruptParameterReferenceException;
import by.epam.javatraining.kutsko.task4.model.exception.NoSuchTextFragmentException;

/**
 * Provides tools for text analyzing
 * 
 * @author Kutsko Kate
 * @version 1.0 21.03.19
 */
public class TextAnalyzer {

	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
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

			char firstLetter = 'a';
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

	private static List<Sentence> getSentences(Text text) {

		List<Sentence> sentenceList = new ArrayList<>();

		text.getAllFragments().forEach((textBlockNumber, textBlock) -> {

			if (textBlock instanceof Paragraph) {
				Paragraph paragraph = (Paragraph) textBlock;

				paragraph.getAllFragments().forEach((sentenceNumber, sentence) -> {
					sentenceList.add((Sentence) sentence.clone());
				});
			}
		});
		return sentenceList;
	}

	private static String buildString(List<Sentence> sentenceList) {

		StringBuilder builder = new StringBuilder();

		for (Sentence sentence : sentenceList) {
			builder.append(sentence.toString()).append("\n");
		}
		return builder.toString();
	}

	public static String swapFirstAndLast(Text text) {

		if (text != null) {

			List<Sentence> sentenceList = getSentences(text);

			for (Sentence sentence : sentenceList) {

				try {

					int lastIndex = sentence.getAmountOFragments() - 1;
					
					Word firstWord = (Word) sentence.getElement(0);
					firstWord.setContents(firstWord.toString().toLowerCase());
					
					TextUnit unit = sentence.getElement(lastIndex);

					if (!(unit instanceof Word)) {
						unit = sentence.getElement(--lastIndex);
					}

					Word lastWord = (Word) unit;

					sentence.replace(0, lastWord);
					sentence.replace(lastIndex, firstWord);

					firstWord.setContents(
							firstWord.toString().substring(0, 1).toUpperCase() + lastWord.toString().substring(1));
					lastWord.setContents(lastWord.toString().toLowerCase());

				} catch (NoSuchTextFragmentException e) {
					LOGGER.info("Nonexistent text fragment was addressed");
				} catch (CorruptParameterReferenceException e) {
					LOGGER.info("Reference to parameter was null");
				}
			}
			return buildString(sentenceList);

		} else {
			LOGGER.info("Reference to text was null");
		}
		return "";
	}

	public static String reverseWordsInSentences(Text text) {

		if (text != null) {

			List<Sentence> sentenceList = getSentences(text);

			for (Sentence sentence : sentenceList) {

				try {

					TextUnit check = null;
					Word firstWord = null;
					Word secondWord = null;

					int previousFirstWordIndex = -1;
					int previousSecondWordIndex = sentence.getAmountOFragments();
					int middle = previousSecondWordIndex / 2;

					boolean stop = false;

					while (!stop) {

						int i = previousFirstWordIndex;

						while (i < middle) {
							i++;
							previousFirstWordIndex = i;
							check = sentence.getElement(previousFirstWordIndex);

							if (check instanceof Word) {
								firstWord = (Word) check;
								break;
							}
						}

						int j = previousSecondWordIndex;

						while (j >= middle) {

							j--;
							previousSecondWordIndex = j;
							check = sentence.getElement(previousSecondWordIndex);

							if (check instanceof Word) {
								secondWord = (Word) check;
								break;
							}
						}

						sentence.replace(previousFirstWordIndex, secondWord);
						sentence.replace(previousSecondWordIndex, firstWord);
						if (i >= j) {
							stop = true;
						}
					}
					firstWord = (Word) sentence.getElement(0);

					if ((check = sentence.getElement(sentence.getAmountOFragments() - 1)) instanceof Word) {
						secondWord = (Word) check;
					} else {
						secondWord = (Word) sentence.getElement(sentence.getAmountOFragments() - 2);
					}

					firstWord.setContents(
							firstWord.toString().substring(0, 1).toUpperCase() + firstWord.toString().substring(1));
					secondWord.setContents(secondWord.toString().toLowerCase());

				} catch (NoSuchTextFragmentException e) {
					LOGGER.info("Nonexistent text fragment was addressed");
				} catch (CorruptParameterReferenceException e) {
					LOGGER.info("Reference to parameter was null");
				}
			}
			return buildString(sentenceList);
		} else {
			LOGGER.warn("Reference to text was null");
		}
		return "";
	}
}
