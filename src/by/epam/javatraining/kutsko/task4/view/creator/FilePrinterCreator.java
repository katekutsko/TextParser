package by.epam.javatraining.kutsko.task4.view.creator;

import by.epam.javatraining.kutsko.task4.view.FilePrinter;
import by.epam.javatraining.kutsko.task4.view.Printable;

public class FilePrinterCreator implements AbstractViewerCreator {

	public Printable create() {
		return new FilePrinter();
	}

}
