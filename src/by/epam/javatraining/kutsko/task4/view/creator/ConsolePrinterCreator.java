package by.epam.javatraining.kutsko.task4.view.creator;

import by.epam.javatraining.kutsko.task4.view.ConsolePrinter;
import by.epam.javatraining.kutsko.task4.view.Printable;

public class ConsolePrinterCreator implements AbstractViewerCreator {

	public Printable create() {
		return new ConsolePrinter();
	}

}
