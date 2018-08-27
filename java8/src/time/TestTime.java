package time;

import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.*;
public class TestTime {
    public static void main(String[] args) {
//        LocalDate date = LocalDate.now();
//        System.out.println(date.getYear());
//        System.out.println(date.getMonth());
//        System.out.println(date.getDayOfMonth());
//        System.out.println(date.getDayOfWeek());
//        System.out.println(date.lengthOfYear());
//        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
//
//        LocalTime time = LocalTime.now();
//        System.out.println(time.getHour());
//        System.out.println(time.getMinute());
//        System.out.println(time.getMinute());
//        System.out.println(time.getHour());
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime.toLocalDate());
//        System.out.println(localDateTime.toLocalTime());
//
//        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
//        Duration thirtyMillis = Duration.ofMillis(30);
//
//        Period sevenDays = Period.ofDays(7);
//
//        //操纵，解析和格式化日期
//        LocalDate date1 = LocalDate.of(2014, 3, 18);
//        LocalDate date2 = date1.withYear(2011);
//        LocalDate date3 = date2.withDayOfMonth(25);
//        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 10);
//        LocalDate date5 = date4.plusWeeks(1);
//        LocalDate date6 = date5.minusMonths(1);
//        LocalDate date7 = date6.plus(1, ChronoUnit.MONTHS);
//
//        System.out.println(date1);
//        System.out.println(date2);
//        System.out.println(date3);
//        System.out.println(date4);
//        System.out.println(date5);
//        System.out.println(date6);
//        System.out.println(date7);

//        LocalDate date = LocalDate.of(2014, 3, 18);
//        LocalDate date1 = date.with(nextOrSame(DayOfWeek.SUNDAY));
//        LocalDate date2 = date1.with(lastDayOfMonth());
//        LocalDate date3 = date2.with(firstDayOfMonth());
//        LocalDate date4 = date3.with(dayOfWeekInMonth(2, DayOfWeek.of(1)));
//        System.out.println(date);
//        System.out.println(date1);
//        System.out.println(date2);
//        System.out.println(date3);
//        System.out.println(date4);
//
//        //自定义下一个工作日，如果当天的星期介于周一至周五之间，日期向后移动一天；如果当天是周六或者周日，则返回下一个周一。
//        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal -> {
//            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
//            int dayToAdd = 1;
//            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
//            if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
//            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
//        });
//        LocalDate nowDate = LocalDate.of(2018,8,10);
//        LocalDate newDate = nowDate.with(nextWorkingDay);
//        System.out.println(newDate);

        //时间日期格式
//        LocalDate date = LocalDate.of(2014, 3, 18);
//        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
//        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
//        System.out.println("s1: "+s1+", s2: "+s2);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formatterDate = date.format(formatter);
//        System.out.println(formatterDate);
//        LocalDate date2 = LocalDate.parse(formatterDate, formatter);
//        System.out.println(date2);

//        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
//        LocalDate date1 = LocalDate.of(2014, 3, 18);
//        String formattedDate = date1.format(italianFormatter);
//        LocalDate date2 = LocalDate.parse(formattedDate, italianFormatter);
//        System.out.println(formattedDate);
//        System.out.println(date2);

        //时区
//        ZoneId romeZone = ZoneId.of("China/BeiJing");
//        LocalDate date = LocalDate.now();
//        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
//        System.out.println(zdt1);
//        LocalDateTime dateTime = LocalDateTime.now();
//        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
//        System.out.println(zdt2);

        //使用格林尼治和当前时区的固定偏差
//        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
//        LocalDateTime dateTime = LocalDateTime.now();
//        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime, newYorkOffset);
//        System.out.println(dateTimeInNewYork);
        GregorianCalendar c = new GregorianCalendar();
        String s = c.getTimeZone().getID();
        System.out.println(s);
    }
}
