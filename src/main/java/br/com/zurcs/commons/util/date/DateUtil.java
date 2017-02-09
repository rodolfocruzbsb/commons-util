package br.com.zurcs.commons.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.zurcs.commons.util.validators.IsNullUtil;

/**
 * <p>
 * <b>Title:</b> DateUtil.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Utilitário para tratamento de data
 * </p>
 * 
 * <p>
 * <b>Company: </b> Rodolfo Cruz T.I.
 * </p>
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public class DateUtil {

	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final String pt_BR_DDMMYYYYY = "dd/MM/yyyy";

	public static final String pt_BR_DDMMYYYYY_HH_MM_SS_S = "dd/MM/yyyy HH:mm:ss.S";

	public static final String pt_BR_HH_MM = "HH:mm";

	public static final String pt_BR_HH_MM_SS = "HH:mm:ss";

	public static final String pt_BR_DDMMYYYYY_HH_MM = "dd/MM/yyyy HH:mm";

	public static final String pt_BR_DDMMYYYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";

	public static final String DATA_POR_EXTENSO = "dd 'de' MMMM 'de' yyyy ";

	private DateUtil() {

		throw new IllegalStateException("Class Not Instantiable");
	}

	/**
	 * Retorna a data atual no formato java.util.Date.
	 * 
	 * @see java.lang.System.currentTimeMillis()
	 */
	public static Date getDateNow() {

		return new Date(System.currentTimeMillis());
	}

	/**
	 * Retorna a data atual no formato java.lang.String.
	 */
	public static String getDateNowStr() {

		final DateFormat df = new SimpleDateFormat(DateUtil.pt_BR_DDMMYYYYY);
		return df.format(DateUtil.getDateNow());
	}

	/**
	 * Retorna uma String de data no formato "dd/MM/yyyy HH:mm:ss.S".
	 */
	public static String getDateNowWithTimeStr() {

		final DateFormat df = new SimpleDateFormat(DateUtil.pt_BR_DDMMYYYYY_HH_MM_SS_S);
		return df.format(DateUtil.getDateNow());
	}

	/**
	 * Retorna uma String de data no formato "dd/MM/yyyy".
	 */
	public static String getDateStr(final Date date) {

		final DateFormat df = new SimpleDateFormat(DateUtil.pt_BR_DDMMYYYYY);
		return df.format(date);
	}

	/**
	 * <p>
	 * Retorna a Data informada convertida no pattern específicado.
	 * </p>
	 * 
	 * @param date
	 *            - Ser convertida
	 * @param pattern
	 *            - Para conversão
	 * @return String da data convertida no patter informado.
	 * @see DateUtil.pt_BR_DDMMYYYYY_HH_MM
	 * @see DateUtil.pt_BR_DDMMYYYYY_HH_MM_SS
	 * @see DateUtil.pt_BR_HH_MM
	 */
	public static String getDateStr(final Date date, final String pattern) {

		String result = "";
		if (!IsNullUtil.isNullOrEmpty(date)) {
			final DateFormat df = new SimpleDateFormat(pattern);
			result = df.format(date);
		}
		return result;
	}

	/**
	 * Retorna um Date da String fornecida "dd/MM/yyyy".
	 */
	public static Date getDate(final String strDate) {

		Date date = null;
		final DateFormat df = new SimpleDateFormat(DateUtil.pt_BR_DDMMYYYYY);
		try {
			if (!IsNullUtil.isNullOrEmpty(strDate)) {
				date = df.parse(strDate);
			}
		} catch (final ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	/**
	 * Retorna um Date da String fornecida "dd/MM/yyyy".
	 * 
	 * @see DateUtil.pt_BR_DDMMYYYYY_HH_MM
	 * @see DateUtil.pt_BR_DDMMYYYYY_HH_MM_SS
	 * @see DateUtil.pt_BR_HH_MM
	 * 
	 * @param date
	 *            - String representando a data
	 * @param pattern
	 *            - Padrao no qual deverá ser convertida a data, default is [br.com.zurcs.utilitario.data.DateUtil.pt_BR_DDMMYYYYY]
	 */

	public static Date getDate(final String strDate, final String pattern) {

		if (IsNullUtil.isNullOrEmpty(pattern)) {
			return DateUtil.getDate(strDate);
		}

		Date date = null;
		final DateFormat df = new SimpleDateFormat(pattern);
		try {
			if (!IsNullUtil.isNullOrEmpty(strDate)) {
				date = df.parse(strDate);
			}
		} catch (final ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	private static Long until(final Date start, final Date end, final TemporalUnit unit) {

		if (IsNullUtil.isNullOrEmpty(start) || IsNullUtil.isNullOrEmpty(end)) {

			return null;
		}

		final Instant inicio = start.toInstant();

		final Instant fim = end.toInstant();

		return inicio.until(fim, unit);
	}

	/**
	 * Retorna qtd de horas entre as datas.
	 */
	public static Long getQtdHoursBetween(final Date start, final Date end) {

		return DateUtil.until(start, end, ChronoUnit.HOURS);
	}

	/**
	 * Retorna a qtd de dias entre as datas.
	 */
	public static Long getQtdDaysBetween(final Date start, final Date end) {

		return DateUtil.until(start, end, ChronoUnit.DAYS);
	}

	/**
	 * Retorna qtd de meses entre as datas.
	 */
	public static Long getQtdMonthsBetween(final Date start, final Date end) {

		return DateUtil.until(start, end, ChronoUnit.MONTHS);
	}

	/**
	 * Retorna a qtd de anos entre as datas.
	 */
	public static long getQtdYearsBetween(final Date start, final Date end) {

		return DateUtil.until(start, end, ChronoUnit.YEARS);
	}

	/**
	 * Retorna a qtd de minutos entre as datas.
	 */
	public static long getQtdMinutesBetween(final Date start, final Date end) {

		return DateUtil.until(start, end, ChronoUnit.MINUTES);
	}

	/**
	 * Retorna uma String contendo a data atual por extenso.
	 * <p>
	 * Ex: Sexta-feira, 9 Dezembro 2016
	 * </p>
	 */
	public static String getDataAtualPorExtenso() {

		return DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy").format(ZonedDateTime.now());

	}

	/**
	 * Verifica se a String passada e uma data valida no calendario.
	 * 
	 * @see DateUtil.pt_BR_DDMMYYYYY_HH_MM
	 * @see DateUtil.pt_BR_DDMMYYYYY_HH_MM_SS
	 * @see DateUtil.pt_BR_HH_MM
	 * 
	 * @param date
	 *            - String representando a data
	 * @param pattern
	 *            - Padrao a ser checado, default is [br.com.zurcs.utilitario.data.DateUtil.pt_BR_DDMMYYYYY]
	 */
	public static boolean isValid(final String date, final String pattern) {

		try {

			DateTimeFormatter.ofPattern(!IsNullUtil.isNullOrEmpty(pattern) ? pattern : DateUtil.pt_BR_DDMMYYYYY).parse(date);

			return true;
		} catch (final DateTimeParseException e) {

			return false;
		}
	}

	public static boolean isValid(final String data) {

		return DateUtil.isValid(data, DateUtil.pt_BR_DDMMYYYYY);
	}

	/**
	 * Retorna a qtd de minutos no horario, ex: 2 horas e 24 minutos e 05 segundos: 8645 segundos
	 */
	public static int extraiQtdSegundos(final LocalTime localTime) {

		return IsNullUtil.isNullOrEmpty(localTime) ? 0 : localTime.get(ChronoField.SECOND_OF_DAY);
	}

	/**
	 * Retorna a qtd de minutos no horario, ex: 2 horas e 24 minutos: 144 minutos
	 */
	public static int extraiQtdMinutos(final LocalTime localTime) {

		return IsNullUtil.isNullOrEmpty(localTime) ? 0 : localTime.get(ChronoField.MINUTE_OF_DAY);
	}

	/**
	 * <p>
	 * Recupera as maiores medidas a partir das horas para a data informada:
	 * </p>
	 * <p>
	 * Ex: 28/01/2015 12:00:30.989 -> 28/01/2015 <b>23:59:59.999</b>
	 * </p>
	 * 
	 * @param data
	 * @return
	 */
	public static LocalDateTime extractMax(final Date data) {

		if (IsNullUtil.isNullOrEmpty(data)) {
			return null;
		}

		final LocalDate localDate = LocalDate.from(data.toInstant().atZone(ZoneId.systemDefault())).plusDays(1);

		return DateUtil.extractMax(localDate);
	}

	public static LocalDateTime extractMax(final LocalDate data) {

		if (IsNullUtil.isNullOrEmpty(data)) {

			return null;
		}

		final LocalDate dataSemTime = LocalDate.from(data).plusDays(1);

		return dataSemTime.atStartOfDay().plusDays(1).minus(1, ChronoUnit.MINUTES);
	}

	/**
	 * <p>
	 * Recupera as menores medidas a partir das horas para a data informada:
	 * </p>
	 * <p>
	 * Ex: 28/01/2015 12:00:30.989 -> 28/01/2015 <b>00:00:00.000</b>
	 * </p>
	 * 
	 * @param data
	 * @return
	 */
	public static LocalDateTime extractMin(final Date data) {

		if (IsNullUtil.isNullOrEmpty(data)) {
			return null;
		}

		final LocalDate localDate = LocalDate.from(data.toInstant().atZone(ZoneId.systemDefault())).plusDays(1);

		return DateUtil.extractMin(localDate);
	}

	public static LocalDateTime extractMin(final LocalDate data) {

		if (IsNullUtil.isNullOrEmpty(data)) {
			return null;
		}

		final LocalDate dataSemTime = LocalDate.from(data).plusDays(1);

		return dataSemTime.atStartOfDay();
	}

	public static String javaToJsDate(final Date data) {

		final SimpleDateFormat fYear = new SimpleDateFormat("yyyy");
		final SimpleDateFormat fMonth = new SimpleDateFormat("MM");
		final SimpleDateFormat f = new SimpleDateFormat("dd, HH, mm, ss");
		String restante = "", y = "", m = "", dataRet = "";
		if (data == null) {
			return "";
		}
		y = fYear.format(data.getTime());
		m = fMonth.format(data.getTime());
		restante = f.format(data.getTime());
		dataRet = y + "," + ( Integer.parseInt(m) - 1 ) + ", " + restante;
		return "new Date(" + dataRet + ")";
	}

	public static String javaToJsDate(final Calendar data) {

		final Date d = data.getTime();
		return DateUtil.javaToJsDate(d);
	}

	/**
	 * 
	 * <p>
	 * Cria um {@link Date} com o instante no tempo atual <i>aka</i> agora.
	 * </p>
	 * 
	 * @return
	 * 
	 */
	public static Date agora() {

		return DateUtil.getDateNow();
	}

	/**
	 * 
	 * <p>
	 * Formata a data informada por extenso, no formato <code> "dd 'de' MMMM 'de' yyyy <code>.
	 * </p>
	 * 
	 * @param date
	 * @return
	 */
	public static String getDataPorExtenso(final Date date) {

		final SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DATA_POR_EXTENSO);
		return sdf.format(date);
	}

	public static List<Integer> getYears(int from, final int to) {

		final List<Integer> years = new ArrayList<>();

		for (; from < to; from++) {
			years.add(Integer.valueOf(from + 1));
		}

		return years;
	}

	/**
	 * Método responsável por verificar se a data informada é fim de semana.
	 *
	 *
	 * @param data
	 * @return TRUE se a data informada for fim de semana.
	 */
	public static boolean ehFimDeSemana(final Date data) {

		if (IsNullUtil.isNullOrEmpty(data)) {

			return false;
		}

		final LocalDate localDate = LocalDate.from(data.toInstant().atZone(ZoneId.systemDefault()));

		return localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);

	}

}
