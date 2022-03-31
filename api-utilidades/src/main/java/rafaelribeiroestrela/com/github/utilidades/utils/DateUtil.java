package rafaelribeiroestrela.com.github.utilidades.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import rafaelribeiroestrela.com.github.utilidades.services.exceptions.ApiException;

public class DateUtil {
	
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
	
	public static LocalDate convertStringToDate(String date, String mask) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mask);
			return LocalDate.parse(date, formatter);
		}catch (IllegalArgumentException e) {
			throw new ApiException("Erro ao converter a data " + date + "com a mascara " + mask + " " + e.getMessage());
		}catch (NullPointerException e){
			throw new ApiException("Erro ao converter a data " + date + "com a mascara " + mask + " " + e.getMessage());
		}
		
	}
	
	public static long differenceBetweenDatesInYears(LocalDate date1, LocalDate date2) {
		return Math.abs(ChronoUnit.YEARS.between(date1, date2));
	}
	
	public static long differenceBetweenDatesInMonths(LocalDate date1, LocalDate date2) {
		return Math.abs(ChronoUnit.MONTHS.between(date1, date2));
	}
	
	public static long differenceBetweenDatesInDays(LocalDate date1, LocalDate date2) {
		return Math.abs(ChronoUnit.DAYS.between(date1, date2));
	}
	
	public static long differenceBetweenDates(LocalDate date1, LocalDate date2) {
		long years = differenceBetweenDatesInYears(date1, date2);
		long months = differenceBetweenDatesInMonths(date1, date2);
		long days = differenceBetweenDatesInDays(date1, date2);
		return 1L;
	}
}
