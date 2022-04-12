package rafaelribeiroestrela.com.github.utilidades.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import rafaelribeiroestrela.com.github.utilidades.exceptions.ApiException;

public class DateUtil {
	
	
	//Array com os meses do ano em String
	private static String[] MONTHS = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	
	
	//Converte data em LocalDate para String
	public static String convertDateToString(LocalDate date, String mask) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mask);
			return date.format(formatter);
		}catch (IllegalArgumentException e){
			throw new ApiException("Erro ao converter a data " + date + " com a mascara " + mask + " " + e.getMessage());
		}catch (NullPointerException e){
			throw new ApiException("Erro ao converter a data " + date + " com a mascara " + mask + " " + e.getMessage());
		}
	}
	
	//Converte data em String para LocalDate
	public static LocalDate convertStringToDate(String date, String mask) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mask);
			return LocalDate.parse(date, formatter);
		}catch (IllegalArgumentException e) {
			throw new ApiException("Erro ao converter a data " + date + " com a mascara " + mask + " " + e.getMessage());
		}catch (NullPointerException e){
			throw new ApiException("Erro ao converter a data " + date + " com a mascara " + mask + " " + e.getMessage());
		}
		
	}
	
	//Diferença entre datas em anos
	public static long differenceBetweenDatesInYears(LocalDate date1, LocalDate date2) {
		return Math.abs(ChronoUnit.YEARS.between(date1, date2));
	}
	
	
	//Diferença entre datas em meses
	public static long differenceBetweenDatesInMonths(LocalDate date1, LocalDate date2) {
		return Math.abs(ChronoUnit.MONTHS.between(date1, date2));
	}
	
	
	//Diferença entre datas em dias
	public static long differenceBetweenDatesInDays(LocalDate date1, LocalDate date2) {
		return Math.abs(ChronoUnit.DAYS.between(date1, date2));
	}
	
	
	//Verifica se a data é futura em relação a outra
	public static boolean checkDateIsFuture(LocalDate present, LocalDate future) {
		return future.isAfter(present);
	}
	
	//Verifica se a data é passada em relação a outra
	public static boolean checkDateIsPast(LocalDate present, LocalDate past) {
		return past.isBefore(present);
	}
	
	//Verifica se a data é igual a outra
	public static boolean checkDateIsEquals(LocalDate date1, LocalDate date2) {
		return date1.isEqual(date2);
	}
	
	//Converte data em Date para LocalDate
	public static LocalDate convertDateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	//Pega o ano da data
	public static int getYearFromDate(LocalDate date) {
		return date.getYear();
	}
	
	//Pega o mes da data
	public static int getMonthFromDate(LocalDate date) {
		return date.getMonthValue();
	}
	
	//Pega o dia da data
	public static int getDayFromDate(LocalDate date) {
		return date.getDayOfMonth();
	}
	
	//Pega a data em forma extensa
	public static String getDateInFullName(LocalDate date) {
		String day = String.valueOf(date.getDayOfMonth());
		if (day.length() == 1) {
			day = "0" + day;
		}
		String month = MONTHS[date.getMonthValue() - 1];
		String year = String.valueOf(date.getYear());
		return day + " de " + month + " de " + year;
	}
	
	
	
}
