package br.com.printer.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * The type Logger.
 */
public final class LogService {

	/**
	 * The constant BREAK_LINE.
	 */
	private static final String BREAK_LINE = "\r\n";

	/**
	 * The constant ERROR_SUFFIX.
	 */
	public static final String ERROR_SUFFIX = "_ERRO.txt";

	/**
	 * The Logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger(LogService.class);

	/**
	 * Create error file.
	 *
	 * @param exception the exception
	 * @param filePath  the file path
	 */
	public static void createErrorFile(Exception exception, Path filePath) {
		StringBuilder exceptionMessageBuilder = new StringBuilder();
		exceptionMessageBuilder.append(exception.getClass().getName());
		exceptionMessageBuilder.append(": ").append(exception.getMessage()).append(BREAK_LINE);

		List<StackTraceElement> traceElements = Arrays.asList(exception.getStackTrace());
		traceElements.forEach(e -> exceptionMessageBuilder.append(e).append(BREAK_LINE));

		String basePath = filePath.toString();
		basePath = basePath.substring(0, basePath.lastIndexOf("."));

		try (FileOutputStream os = new FileOutputStream(basePath + ERROR_SUFFIX);
		     PrintWriter writer = new PrintWriter(os)) {

			writer.print(exceptionMessageBuilder.toString());
			System.out.println("Ocorreu um erro durante a impressão do arquivo " + filePath.toString());

		} catch (Exception e) {
			log(Level.ERROR, e.getMessage(), e);
		}
	}

	/**
	 * Log.
	 *
	 * @param level     the level
	 * @param message   the message
	 * @param throwable the throwable
	 */
	public static void log(Level level, String message, Throwable throwable) {
		LOGGER.log(level, message, throwable);
	}

	/**
	 * Log.
	 *
	 * @param level   the level
	 * @param message the message
	 */
	public static void log(Level level, String message) {
		LOGGER.log(level, message);
	}

}
