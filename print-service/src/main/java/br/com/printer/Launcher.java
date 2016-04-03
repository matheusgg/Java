package br.com.printer;

import br.com.printer.monitoring.MonitoringService;

import java.nio.file.Paths;

/**
 * The type Launcher.
 */
public class Launcher {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		String monitoredDirectory = System.getProperty("monitoredDirectory");
		String logDirectory = System.getProperty("logDirectory");

		if (monitoredDirectory == null || logDirectory == null) {
			throw new IllegalArgumentException("Por favor, informe o diretório de monitoramento e o diretório de arquivos de log.");
		}

		new MonitoringService().startDirectoryMonitoring(Paths.get(monitoredDirectory));
	}

}
