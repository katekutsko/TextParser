package by.epam.javatraining.kutsko.task4.model.logic;

import org.testng.annotations.Test;

import by.epam.javatraining.kutsko.task4.model.entity.Text;
import jdk.nashorn.internal.ir.annotations.Ignore;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;

public class TextAnalyzerTest {

	private Text text;
	private String reverse;
	private String swap;
	private String alphabet;

	@Test(dataProvider = "dp")
	public void f(Text text, String swap, String reverse, String alphabet) {
		this.swap = swap;
		this.reverse = reverse;
		this.alphabet = alphabet;
		this.text = text;
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				new Object[] { new Text(
						"\tThis is a text. \n\n\tthis = is(some.code());\n\n\tThis is another short paragraph. "),
						"Text is a this.\nParagraph is another short this.\n",
						"Text a is this.\nParagraph short another is this.\n",
						"\ta another \n\tis \n\tparagraph \n\tshort \n\ttext this " },
				new Object[] { new Text(
						"\tThis is a longer, more complex text. There are 2 sentences in paragraph now.\n\n\tthis = is(some.code());\n\tNow<it> consists = of two(Elements<too>);\n\n\tThis is another short paragraph. "),
						"Text is a longer, more complex this.\nNow are 2 sentences in paragraph there.\nParagraph is another short this.\n",
						"Text complex more longer, a is this.\nNow paragraph in sentences 2 are there.\nParagraph short another is this.\n",
						"\t\n\t2 \n\ta another are \n\tcomplex \n\tin is \n\tlonger \n\tmore \n\tnow \n\tparagraph \n\tsentences short \n\ttext there this " }, };
	}

	@Test
	public void testSwapFirstAndLast() {

		String actual = TextAnalyzer.swapFirstAndLast(text);

		assertEquals(actual, swap);
	}

	@Test
	public void testReverseWordsInSentences() {

		String actual = TextAnalyzer.reverseWordsInSentences(text);

		assertEquals(actual, reverse);
	}

	@Test
	public void testGetWordsInAlphabeticalOrder() {

		String actual = TextAnalyzer.getAllWordsOfTextInAlphabeticOrder(text);

		assertEquals(actual, alphabet);
	}

}
