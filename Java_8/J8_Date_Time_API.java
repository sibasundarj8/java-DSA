package Java_8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class J8_Date_Time_API {
    public static void main(String[] args) {


    /// getting current Date using LocalDate
        LocalDate today = LocalDate.now();  // XXXX:XX:XX
        System.out.println(today);          // year : month : day

        // setting custom date and printing separately
        LocalDate myDate = LocalDate.of(2001, 4, 24);
        int year = myDate.getYear();
        Month month = myDate.getMonth();
        int day = myDate.getDayOfMonth();
        System.out.printf("%d-%s-%d\n",day,month,year);

        // getting previous date
        LocalDate minusDate = today.minusYears(10);
        System.out.println(minusDate);

        // checking dates returns a boolean value
        LocalDate birthday = LocalDate.of(2004,2,2);
        System.out.println(birthday.isAfter(myDate));

        // Getting Duration
        System.out.println(Period.between(birthday, myDate));


    /// Getting current Time using LocalTime
        LocalTime now = LocalTime.now();    // XX:XX:XX:XXXXXX
        System.out.println(now);            // hr : min : sec : nano-sec

        // setting custom time
        LocalTime customTime = LocalTime.of(12, 12, 12);
        System.out.println(customTime);

        // Getting previous time
        LocalTime minusTime = now.minusHours(2);
        System.out.println(minusTime);

        // Getting time from String
        System.out.println(LocalTime.parse("10:35"));

        // checking times returns a boolean value
        System.out.println(now.isBefore(minusTime));


    /// Getting current date and time using LocalDateTime
        LocalDateTime cur = LocalDateTime.now();    // XXXX:XX:XXTXX:XX:XXXXXX
        System.out.println(cur);                    // year : month : day T hr : min : sec : nano-sec

        // setting custom date and time
        LocalDateTime customDateTime = LocalDateTime.of(2004,2,2,12,12);
        System.out.println(customDateTime);

        // Getting date and time from String
        System.out.println(LocalDateTime.parse("2001-04-24T12:12"));


    /// Zoned Date and Time
        ZonedDateTime zone = ZonedDateTime.now(); // XXXX:XX:XXTXX:XX:XXXXXX+xx:xx[Timezone/name]
        System.out.println(zone);                // year : month : day T hr : min : sec : nano-sec (+/-) hr : min [Asia/Calcutta]

        // getting available Zone Ids
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        // getting America/St_Barthelemy current date and time
        ZonedDateTime americaTime = ZonedDateTime.now(ZoneId.of("America/St_Barthelemy"));
        System.out.println(americaTime);

        // getting current date and time from a String
        System.out.println(ZonedDateTime.parse("2024-12-04T12:35:56.968993200-04:00[America/St_Barthelemy]"));


    /// Instant - This class models a single instantaneous point on the time-line. This might be used to record event time-stamps in the application.
    /// The epoch-seconds are measured from the standard Java epoch of 1970-01-01T00:00:00Z
        Instant instant = Instant.now();
        System.out.println(instant);


    /// Duration - A time-based amount of time, such as '34.5 seconds'. We should use for short duration only
        try{      // waiting of 1.25 seconds
            Thread.sleep(1250);
        }
        catch (InterruptedException e){
            System.out.println("Exception caught: " + e);
        }
        Instant instant1 = Instant.now();
        Duration d = Duration.between(instant, instant1);
        System.out.println(d);

        // Comparing two durations -- returns difference between 2 durations
        Duration d1 = Duration.of(1, ChronoUnit.SECONDS);
        System.out.println(d1.compareTo(d));


    /// Period - This class models a quantity or amount of time in terms of years, months and days. We should use it for long periods.
        LocalDate l1 = LocalDate.of(2001, 4, 24);
        LocalDate l2 = LocalDate.now();
        Period period = Period.between(l1, l2);
        System.out.println(period);


    /// Date Time Formatter
        LocalDate localDate = LocalDate.of(2001,4,24);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format = localDate.format(formatter);
        System.out.println(format);

        // Getting date from a String of format -- dd/MM/yyyy
        String date = "02/02/2004";
        LocalDate date1 = LocalDate.parse(date, formatter);
        System.out.println(date1.format(formatter));
    /*
     * y - year
     * M - month of year
     * d - day of month
     * H - hour of day (0 - 23)
     * h - hour of am/pm (1 - 12)
     * m - minute of hour
     * s - second of minute
     * S - fraction of second
     * a - am / pm marker
     * E - day of week
     * D - day of year
     * F - day of week in month
     * w - week of year
     * W - week of month
     * k - hour of day (1 - 24)
     * K - hour of am/pm (0 - 11)
     * z - time zone name
     * Z - time zone offset
     */
        // changing format of a zoned date time
        String zoned = "2023-04-24 10:30:45+05:30";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(zoned, dateTimeFormatter);
        System.out.println(zonedDateTime);
    }
}
