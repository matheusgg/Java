package br.com.printer.print;

import br.com.printer.log.LogService;
import org.apache.logging.log4j.Level;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobPriority;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The type Printer.
 */
public final class Printer {

	/**
	 * The Print service.
	 */
	private PrintService printService;

	/**
	 * Instantiates a new Printer.
	 */
	public Printer() {
		// Recuperando a impressora padrao
		this.printService = PrintServiceLookup.lookupDefaultPrintService();
	}

	/**
	 * Print.
	 *
	 * @param filePath the filePath
	 */
	public void print(Path filePath) {
		if (!Files.isDirectory(filePath) && !filePath.toString().endsWith(LogService.ERROR_SUFFIX)) {
			new Thread(() -> {
				try (InputStream fileStream = Files.newInputStream(filePath)) {
					// Definindo o tipo do documento que sera impresso
					DocFlavor type = DocFlavor.INPUT_STREAM.AUTOSENSE;

					// Criando o servico de impressao e registrando um listener que acompanhara a impressao
					DocPrintJob printJob = this.printService.createPrintJob();
					printJob.addPrintJobListener(new PrintJobListener(filePath));

					PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
					attributes.add(new JobPriority(100));

					LogService.log(Level.INFO, "Iniciando impressão do arquivo " + filePath);

					// Envia o documento para a fila de impressao da impressora padrao
					printJob.print(new SimpleDoc(fileStream, type, null), attributes);

				} catch (Exception e) {
					LogService.log(Level.ERROR, e.getMessage(), e);
				}
			}).start();
		}
	}

}
