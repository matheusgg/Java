package cap10.dateTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		/*
		 * A API Java Time é imutável. É possível adicionar valores com os
		 * métodos plus**
		 */
		LocalDate mesQueVem = LocalDate.now().plusMonths(1);
		System.out.println(mesQueVem);

		LocalDate anoQueVem = LocalDate.now().plusYears(1);
		System.out.println(anoQueVem);

		/*
		 * Os método to** são uilizados para realizar a conversão para outros
		 * tipos.
		 */
		System.out.println("====================================================");
		LocalDate dataAtual = LocalDateTime.now().toLocalDate();
		System.out.println(dataAtual);

		/*
		 * Para alterar um valor, basta chamar os métodos with**.
		 */
		System.out.println("====================================================");
		LocalDate anoPassado = LocalDate.now().withYear(2014);
		System.out.println(anoPassado);

		/*
		 * Para recupar informações, basta chamar os métodos get**.
		 */
		System.out.println("====================================================");
		System.out.println(anoPassado.getYear());

		System.out.println("====================================================");
		ZonedDateTime saoPaulo = ZonedDateTime.of(2015, 1, 6, 17, 5, 0, 0, ZoneId.of("America/Sao_Paulo"));
		ZonedDateTime tokyo = ZonedDateTime.of(2015, 1, 6, 17, 5, 0, 0, ZoneId.of("Asia/Tokyo"));

		tokyo = tokyo.plusHours(11);
		System.out.println(tokyo.isEqual(saoPaulo));

		System.out.println(saoPaulo.toEpochSecond() + " / " + saoPaulo.toLocalTime().getNano());
		System.out.println(tokyo.toEpochSecond() + " / " + tokyo.toLocalTime().getNano());

		/*
		 * Meses
		 */
		System.out.println("====================================================");
		System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));

		/*
		 * Formatação de datas
		 */
		System.out.println("====================================================");
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		String data = dataHoraAtual.format(DateTimeFormatter.ISO_DATE_TIME);

		LocalDateTime localDateTime = LocalDateTime.parse(data, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(localDateTime);

		/*
		 * Períodos são relacionados a data.
		 */
		System.out.println("====================================================");
		LocalDate nascimento = LocalDate.of(1993, Month.JANUARY, 10);
		LocalDate hoje = LocalDate.of(2015, Month.JANUARY, 06);
		System.out.println(ChronoUnit.DAYS.between(nascimento, hoje));

		Period periodo = Period.between(nascimento, hoje);
		System.out.println(periodo.getYears());

		/*
		 * Durações são relacionadas a hora
		 */
		System.out.println("====================================================");
		LocalDateTime agora = LocalDateTime.now();
		LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);

		Duration duracao = Duration.between(agora, daquiAUmaHora);
		System.out.println(duracao.toMinutes());
	}

}
