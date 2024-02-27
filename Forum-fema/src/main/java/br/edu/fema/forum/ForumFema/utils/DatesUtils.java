package br.edu.fema.forum.ForumFema.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DatesUtils {

    private static final String BRAZIL_DATE_FORMAT_PATTERN = "dd/MM/yyyy";
    private static final ZoneId BRAZIL_ZONE_ID = ZoneId.ofOffset("GMT", ZoneOffset.ofHours(-3));

    public static ZoneId brZoneID () {
      return BRAZIL_ZONE_ID;
    }
    public static String transformLocalDateToString(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(BRAZIL_DATE_FORMAT_PATTERN));
    }

    public static LocalDate transformStringToLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(BRAZIL_DATE_FORMAT_PATTERN));
    }
}
