package by.epam.javatraining.kutsko.task4.model.entity;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.javatraining.kutsko.task4.model.exception.CorruptParameterReferenceException;

public class WordTest {
	
	private Word first;
	private Word second;
	private boolean expected;

	@Test(dataProvider = "dp")
	public void f(Word v, Word n, Boolean s) {
		first = v;
		second = n;
		expected = s;
	}
	
	@DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] {new Word(""), null, false},
	      new Object[] {new Word("word"), new Word("word"), true },
	      new Object[] {new Word("word"), new Word("WORD"), false}
	    };
	  }
	
	@Test
	public void testCopying—onstructor() {
		
		Word expected = new Word("Word");
		
		Word actual = new Word(expected);
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testCloning() {
		
		Word expected = new Word("Word");
		
		Word actual = expected.clone();
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testEquals() {
		
		boolean actual = first.equals(second);
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testClear() {
		
		Word expected = new Word("");
		Word actual = new Word("Word");
		
		actual.clear();
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testIsEmpty() {
		boolean expected = false;
		boolean actual = new Word("Word").isEmpty();
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testSetContents() throws Exception {
		Word expected = new Word("Word");
		Word actual = new Word();
		
		actual.setContents("Word");
		
		assertEquals(actual, expected);
	}
	
	@Test 
	public void testSetInvalidContents() throws Exception {
		Word expected = new Word("Word");
		Word actual = new Word("Word");
		
		actual.setContents(null);
		
		assertEquals(actual, expected);
	}
}
