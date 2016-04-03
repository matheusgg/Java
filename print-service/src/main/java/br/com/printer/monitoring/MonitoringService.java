package br.com.printer.monitoring;

import br.com.printer.log.LogService;
import br.com.printer.print.Printer;
import org.apache.logging.log4j.Level;

import java.nio.file.*;
import java.util.List;

/**
 * The type Monitoring service.
 */
public class MonitoringService {

	/**
	 * The Printer.
	 */
	private Printer printer;

	/**
	 * Instantiates a new Monitoring service.
	 */
	public MonitoringService() {
		this.printer = new Printer();
	}

	/**
	 * Start directory monitoring.
	 *
	 * @param directoryPath the directory path
	 */
	public void startDirectoryMonitoring(Path directoryPath) {
		if (!Files.isDirectory(directoryPath)) {
			throw new IllegalArgumentException("O diretório de monitoramento nao pôde ser encontrado.");
		}

		try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
			directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			while (true) {
				WatchKey key = watchService.poll();

				if (key != null) {
					LogService.log(Level.INFO, "Arquivos encontrados...");
					List<WatchEvent<?>> events = key.pollEvents();
					events.stream().map(e -> directoryPath.resolve(((WatchEvent<Path>) e).context())).forEach(this.printer::print);
					key.reset();
				}
			}
		} catch (Exception e) {
			LogService.log(Level.ERROR, e.getMessage(), e);
		}
	}

}
