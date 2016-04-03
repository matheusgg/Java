package br.com.printer.print;

import br.com.printer.log.LogService;
import org.apache.logging.log4j.Level;

import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The type Print job listener.
 */
public class PrintJobListener extends PrintJobAdapter {

	/**
	 * The File path.
	 */
	private Path filePath;

	/**
	 * The Has errors.
	 */
	private boolean hasErrors;

	/**
	 * Instantiates a new Print job listener.
	 *
	 * @param filePath the file path
	 */
	public PrintJobListener(Path filePath) {
		this.filePath = filePath;
	}

	/**
	 * Print job failed.
	 *
	 * @param pje the pje
	 */
	@Override
	public void printJobFailed(PrintJobEvent pje) {
		this.hasErrors = true;
	}

	/**
	 * Print job no more events.
	 *
	 * @param pje the pje
	 */
	@Override
	public void printJobNoMoreEvents(PrintJobEvent pje) {
		if (!this.hasErrors && Files.exists(this.filePath)) {
			try {
				Files.delete(this.filePath);
			} catch (IOException e) {
				LogService.log(Level.ERROR, e.getMessage(), e);
			}
		}
	}
}
