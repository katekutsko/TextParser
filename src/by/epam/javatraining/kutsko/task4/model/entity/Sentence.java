package by.epam.javatraining.kutsko.task4.model.entity;

import java.util.HashMap;
import java.util.Map;

public class Sentence extends ComplexTextUnit<SimpleTextUnit> {

	public Sentence(Map<Integer, SimpleTextUnit> sentenceParts) {
		super();
		if (sentenceParts != null) {
			textFragments.putAll(sentenceParts);
		}
	}

	public Sentence() {
		super();
	}

	public Sentence(Sentence sentence) {
		super();
		if (sentence != null) {
			sentence.getAllFragments().forEach((key, value) -> {
				textFragments.put(key, value.clone());
			});
		}
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		textFragments.forEach((key, value) -> {

			int length = builder.length();

			if (value.toString().matches("\\(")) {
				builder.append(value);

			} else {

				if ((value instanceof PunctuationMark) && (length >= 1) && (builder.charAt(length - 1) != '(')) {
					builder.deleteCharAt(length - 1);
				}
				builder.append(value).append(" ");
			}
		});

		builder.deleteCharAt(builder.length() - 1);

		char last = builder.charAt(builder.length() - 1);
		if (last != ':' && last != '.') {
			builder.append(". ");
		}
		return builder.toString();
	}

	@Override
	public Sentence clone() {

		Map<Integer, SimpleTextUnit> map = new HashMap<>();

		textFragments.forEach((key, value) -> {
			map.put(key, (SimpleTextUnit) value.clone());
		});

		return new Sentence(map);
	}
}