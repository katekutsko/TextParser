package by.epam.javatraining.kutsko.task4.util.validator;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class ValidatorTest {
	
	private String testString;
	private boolean expected;
	private String testSymbols;
	private String testCodeBlock;
	
	@Test(dataProvider = "dp")
	public void f(String p, String v, String n, Boolean s) {
		testCodeBlock = p;
		testSymbols = v;
		testString = n;
		expected = s;
	}

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"GGGG", "sdgdf", "89this is an example of an invalid paragraph. \nIt is very short, "
				+ "but contains several sentences and \n has logical completion;", false },
      new Object[] {"list = new ArrayList<>()", "??????", "FGDHKESKTY%#Y#RWGebhdnlkcnjc;ouYD98W7D98S9EFKJM FKVMSDLVK FCSV.", false },
      new Object[] {"list = new ArrayList<>();", ",", "\tThis is an example of a paragraph. It is very short, "
				+ "but \ncontains several sentences and \n has logical completion.", true },
      new Object[] {" ", " ", "\t .", false },
      new Object[] {null, null, null, false }
    };
  }

	@Test
	public void testValidParagraphValidation() {
		boolean actual = Validator.validateAsParagraph(testString);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testPunctuationMarkValidation() {
		boolean actual = Validator.validateAsPunctuationMark(testSymbols);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testCodeBlockValidation() {
		boolean actual = Validator.validateAsPunctuationMark(testSymbols);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testSentenceValidation() {
		boolean expected = true;
		boolean actual = Validator.validateAsSentence("This is a sentence.");
		Assert.assertEquals(actual, expected);
	}
	
}
