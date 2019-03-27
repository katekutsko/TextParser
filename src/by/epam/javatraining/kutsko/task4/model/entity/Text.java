package by.epam.javatraining.kutsko.task4.model.entity;

import java.util.HashMap;
import java.util.Map;

import by.epam.javatraining.kutsko.task4.util.parser.TextParser;

public class Text extends ComplexTextUnit<TextUnit> {

	private static final String PARAGRAPH_SEPARATOR = "\n\n";
	
	public Text() {
		super();
	}

	public Text(String string) {
		super();
		if (string != null) {
			Text newText= TextParser.getInstance().create(string);
			this.addElements(newText.getAllFragments());
		}
	}
	
	public Text(Map<Integer, TextUnit> textParts) {
		super();
		if (textParts != null) {
			textFragments.putAll(textParts);
		}
	}

	@Override
	public Text clone() {
		Map<Integer, TextUnit> map = new HashMap<>();

		textFragments.forEach((key, value) -> {
			map.put(key, (TextUnit) value.clone());
		});

		return new Text(map);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	public Map<Integer, Sentence> getSentences() {

		Map<Integer, Sentence> sentenceList = new HashMap<>();
		textFragments.forEach((textBlockNumber, textBlock) -> {
			
			if (textBlock instanceof Paragraph) {
				
				Paragraph paragraph = (Paragraph) textBlock;
				
				paragraph.getAllFragments().forEach((sentenceNumber, sentence) -> {
					sentenceList.put(sentenceList.size(), (Sentence) sentence.clone());
				});
			} else if (textBlock instanceof Sentence) {
				sentenceList.put(textBlockNumber, (Sentence) textBlock.clone());
			}
		});
		return sentenceList;
	}
	
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		textFragments.forEach((key, value) -> {

			builder.append(value).append(PARAGRAPH_SEPARATOR);
			
		});

		return builder.toString();
	}

}
