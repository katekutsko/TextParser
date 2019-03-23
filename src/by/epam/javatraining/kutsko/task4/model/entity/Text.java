package by.epam.javatraining.kutsko.task4.model.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text extends ComplexTextUnit<TextUnit> {

	public static final String PARAGRAPH_SEPARATOR = "\n\n";
	
	public Text() {
		super();
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
	
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		textFragments.forEach((key, value) -> {

			builder.append(value).append(PARAGRAPH_SEPARATOR);
			
		});

		return builder.toString();
	}

}
