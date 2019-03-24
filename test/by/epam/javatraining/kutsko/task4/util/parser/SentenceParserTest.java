package by.epam.javatraining.kutsko.task4.util.parser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.javatraining.kutsko.task4.model.entity.*;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class SentenceParserTest {
	
	private SentenceParser parser;
	
	@BeforeClass
	public void init() {
		parser = new SentenceParser();
	}
	
	@Test
	public void testCreatingSentence() {
		Map<Integer, SimpleTextUnit> map = new HashMap<>();
		
		map.put(0, new Word("This"));
		map.put(1, new Word("is"));
		map.put(2, new Word("a"));
		map.put(3, new Word("sentence"));
		map.put(4, new PunctuationMark("."));
		Sentence expected = new Sentence(map);
		
		Sentence actual = parser.create("This is a sentence.");
		
		assertEquals(actual, expected);
	}
	

	@Test 
	public void testCreatingSentenceFromNull() {
		Sentence expected = new Sentence();
		
		Sentence actual = parser.create(null);
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testCreatingSentenceFronInvalidString() {
		Sentence expected = new Sentence();
		
		Sentence actual = parser.create("this is not a sentence.");
		
		assertEquals(actual, expected);
	}
}
