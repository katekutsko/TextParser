package by.epam.javatraining.kutsko.task4.model.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
		return "";
	}

	public static String reverseSentences(Text text) {

		if (text != null) {

			List<Sentence> sentenceList = new ArrayList<>();

			text.getAllFragments().forEach((textBlockNumber, textBlock) -> {

				if (textBlock instanceof Paragraph) {

					Paragraph paragraph = (Paragraph) textBlock;

					paragraph.getAllFragments().forEach((sentenceNumber, sentence) -> {
						sentenceList.add((Sentence) sentence.clone());
					});
				}
			});

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
					lastWord.setContents(
					lastWord.toString().substring(0, 1).toUpperCase() +
					lastWord.toString().substring(1));

					sentence.replace(0, lastWord);
					sentence.replace(lastIndex, firstWord);

				} catch (NoSuchTextFragmentException e) {
					// TODO
					e.printStackTrace();
				} catch (CorruptParameterReferenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			StringBuilder builder = new StringBuilder();
			
			for (Sentence sentence : sentenceList) {
				builder.append(sentence.toString()).append("\n");
			}
			return builder.toString();
		}
		return "";
	}
}
