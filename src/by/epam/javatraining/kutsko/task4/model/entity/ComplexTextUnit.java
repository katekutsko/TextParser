package by.epam.javatraining.kutsko.task4.model.entity;

import java.util.HashMap;
import java.util.Map;

import by.epam.javatraining.kutsko.task4.model.exception.NoSuchTextFragmentException;

/**
 * @param <T> represents the type of data container contents depending on the
 *        type of container (e.g. text, paragraph etc.)
 */
public abstract class ComplexTextUnit<T extends TextUnit> extends TextUnit {

	protected Map<Integer, TextUnit> textFragments;

	protected ComplexTextUnit() {
		textFragments = new HashMap<>();
	}

	public int getAmountOFragments() {
		return textFragments.size();
	}

	public boolean add(TextUnit fragment) {

		if (fragment != null) {
			textFragments.put(textFragments.size(), fragment);
			return true;

		} else {
			return false;
		}
	}

	public boolean addElements(Map<Integer, TextUnit> textFragments) {
		if (textFragments != null) {
			for (int i = 0; i < textFragments.size(); i++) {
				this.add(textFragments.get(i));
			}
			return true;
		}
		return false;
	}

	public void clear() {
		textFragments.clear();
	}
	
	public TextUnit getElement(int index) throws NoSuchTextFragmentException {
		
		if (index >= 0 && index < textFragments.size()) {
			return textFragments.get(index);
		} 
		else {
			throw new NoSuchTextFragmentException();
		}
	}
	
	public void replace(int index, TextUnit value) {
		if (textFragments.containsKey(index)) {
			textFragments.replace(index, value);
		}
	}
	
	public Map<Integer, TextUnit> getAllFragments() {
		return textFragments;
	}
	
	public boolean isEmpty() {
		return getAmountOFragments() == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((textFragments == null) ? 0 : textFragments.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		ComplexTextUnit other = (ComplexTextUnit) obj;
		if (textFragments == null) {
			if (other.textFragments != null)
				return false;
		} else if (!textFragments.equals(other.textFragments))
			return false;
		return true;
	}
	
	

}
