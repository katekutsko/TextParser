package by.epam.javatraining.kutsko.task4.model.entity;

import by.epam.javatraining.kutsko.task4.model.exception.CorruptParameterReferenceException;

public abstract class SimpleTextUnit extends TextUnit {

	protected String contents;

	protected SimpleTextUnit() {
		contents = "";
	}

	protected SimpleTextUnit(String line) {
		if (line != null) {
			contents = line;
		}
	}

	public void setContents(String string) {
		if (string != null) {
			contents = string;
		} 
	}

	@Override
	public void clear() {
		contents = "";
	}

	@Override
	public String toString() {
		return contents;
	}

	@Override
	public boolean isEmpty() {
		return contents == null || contents == "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SimpleTextUnit other = (SimpleTextUnit) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		return true;
	}
}
