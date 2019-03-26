package by.epam.javatraining.kutsko.task4.model.entity;

import org.testng.annotations.Test;

import by.epam.javatraining.kutsko.task4.model.exception.NoSuchTextFragmentException;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;

public class SentenceTest {
	
	private Sentence sentence;
	
	@BeforeClass
	public void init() {
		sentence = new Sentence("This is a sentence.");
	}

	@Test
	public void testCopyingConstructor() {
		Sentence expected = sentence;

		Sentence actual = new Sentence(expected);

		assertEquals(actual, expected);
	}

	@Test
	public void testParameterizedConstructor() {
		Sentence expected = new Sentence();
		expected.add(new Word("This"));
		expected.add(new Word("is"));
		expected.add(new Word("a"));
		expected.add(new Word("sentence"));
		expected.add(new PunctuationMark("."));

		Sentence actual = sentence;

		assertEquals(actual, expected);
	}

	@Test
	public void testCloning() {
		Sentence expected = new Sentence("This is a sentence.");

		Sentence actual = expected.clone();

		assertEquals(actual, expected);
	}

	@Test
	public void testGetSize() {
		int expected = 5;

		int actual = sentence.getAmountOFragments();

		assertEquals(actual, expected);
	}

	@Test
	public void testAddElement() {
		Sentence expected = sentence;
		
		Sentence actual = new Sentence("This is a");
		actual.add(new Word("sentence"));
		actual.add(new PunctuationMark("."));
		assertEquals(actual, expected);
	}
	
	@Test
	public void testAddNullElement() {
		Sentence expected = sentence;
		
		Sentence actual = sentence.clone();
		actual.add(null);
		
		assertEquals(actual, expected);
	}

	@Test
	public void testAddElements() {
		Sentence expected = sentence;
		
		Sentence actual = new Sentence();
		Map<Integer, TextUnit> map = new HashMap<>();
		map.put(0, new Word("This"));
		map.put(1, new Word("is"));
		map.put(2, new Word("a"));
		map.put(3, new Word("sentence"));
		map.put(4, new PunctuationMark("."));
		actual.addElements(map);
		
		assertEquals(actual, expected);
	} 
	
	@Test
	public void testGetElement() throws Exception {
		Word expected = new Word("This");
		Word actual = (Word) sentence.getElement(0);
		}
	
	@Test (expectedExceptions = NoSuchTextFragmentException.class)
	public void testGetNonexistentElement() throws Exception {
		sentence.getElement(9);
		}

	@Test
	public void testReplaceElement() {
		Sentence expected = new Sentence("This is a cat.");
		
		Sentence actual =sentence.clone();
		actual.replace(3, new Word("cat"));
		
		assertEquals(actual, expected);
		}
	
	@Test
	public void testReplaceNonexistentElement() {
		Sentence expected = sentence;
		
		Sentence actual = sentence.clone();
		actual.replace(9, new PunctuationMark(","));
		
		assertEquals(actual, expected);
		}
}
