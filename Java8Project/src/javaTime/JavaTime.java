package javaTime;


public class JavaTime {

	public static void main(String[] args) throws InterruptedException {
		// =================================================================
		// Instant agora = Instant.now();
		// Thread.sleep(3000);
		// Instant tempoDecorrido = Instant.now();
		// Duration duracao = Duration.between(agora, tempoDecorrido);
		// System.out.println(duracao.getSeconds());

		// =================================================================
		// LocalDate dataAtual = LocalDate.now();
		// System.out.println(dataAtual);
		//
		// LocalDate nascimento = LocalDate.of(1993, Month.JANUARY, 10);
		// System.out.println(nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		/*
		 * Neste caso é possível utilizar um Duration, porem Period é mais
		 * recomendado, pois ele trata de detalhes como anos bissextos.
		 */
		// Period periodo = Period.between(nascimento, dataAtual);
		// System.out.println(periodo.getYears());

		// =================================================================
		// LocalTime horaAtual = LocalTime.now();
		// System.out.println(horaAtual.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

		// =================================================================
		// LocalDateTime dataHora = LocalDateTime.of(2014, Month.APRIL, 27, 23,
		// 30, 20);
		// System.out.println(dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss")));

		// =================================================================
		// ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
		// ZonedDateTime dataHoraComFusorario = ZonedDateTime.now(zoneId);
		// System.out.println(dataHoraComFusorario);

		// =================================================================
		// MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
		// System.out.println(natal);

		// =================================================================
		// LocalDateTime tempoAtual = LocalDateTime.now();
		// DateTimeFormatter formatter =
		// DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new
		// Locale("pt", "br"));
		// System.out.println(tempoAtual.format(formatter));

		// =================================================================
		/*
		 * Calculo de periodos de datas
		 */
		// MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
		// LocalDate proximoNatal = natal.atYear(Year.now().getValue());
		// System.out.println(LocalDate.now().until(proximoNatal,
		// ChronoUnit.DAYS));

		// LocalDate nascimento = LocalDate.of(1993, Month.JANUARY, 10);
		// System.out.println(nascimento.until(LocalDate.now(),
		// ChronoUnit.YEARS));

		// =================================================================
		/*
		 * Descobrir proximo dia com ajustador
		 */
		// TemporalAdjuster ajustador =
		// TemporalAdjusters.next(DayOfWeek.MONDAY);
		// LocalDate localDate = LocalDate.now().with(ajustador);
		// System.out.println(localDate.getDayOfMonth());

		// =================================================================
		/*
		 * Melhoria na classe Calendar. Um novo Builder foi adicionado a classe
		 * para facilitar e deixar a criacao de um objeto Calendar mais fluido.
		 */
		// Calendar cal = new Calendar.Builder().setDate(1992, 1, 10).build();
		// System.out.println(cal.getTime());

	}
}
