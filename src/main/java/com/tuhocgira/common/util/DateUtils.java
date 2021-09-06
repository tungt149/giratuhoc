package com.tuhocgira.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static final String DATE_FORMAT = "yyyy-MM-dd H:mm:ss";

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	public static LocalDateTime toDate(String date) {
		return LocalDateTime.parse(date, formatter);
	}

	public static String toString(LocalDateTime date) {
		return date.format(formatter);
	}
	
}
