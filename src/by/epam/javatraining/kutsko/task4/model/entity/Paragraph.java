package by.epam.javatraining.kutsko.task4.model.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paragraph extends ComplexTextUnit<Sentence> {

	public Paragraph(List<Sentence> sentences) {

		for (Sentence fragment : sentences) {
			super.add(fragment);
		}
	}

	public Paragraph() {
		super();
	}

	public Paragraph(Map<Integer, ComplexTextUnit<SimpleTextUnit>> sentences) {
		super();
		if (sentences != null) {
			textFragments.putAll(sentences);
		}
	}

	public Paragraph(Paragraph paragraph) {
		super();
		if (paragraph != null) {
			paragraph.getAllFragments().forEach((key, value) -> {
				textFragments.put(key, value.clone());
			});
		}
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("\t");
		
		textFragments.forEach((key, value) -> {

			builder.append(value.toString()).append(" ");

		});

		return builder.toString();
	}

	@Override
	public Paragraph clone() {

		Map<Integer, ComplexTextUnit<SimpleTextUnit>> map = new HashMap<>();

		textFragments.forEach((key, value) -> {
			map.put(key, (ComplexTextUnit<SimpleTextUnit>) value.clone());
		});

		return new Paragraph(map);
	}
}
