package jp.furplag.time;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public final class JulianDayNumber {

  /**
   * Calculates the Julian Day Number from {@link Millis#epochOfJulian} .
   *
   * @param julianDate the Astronomical Julian Date from {@link Millis#epochOfJulian}
   * @return the Julian Day Number from {@link Millis#epochOfJulian}
   */
  public static long ofJulian(final double julianDate) {
    return (long) (julianDate + .5d);
  }

  /**
   * Calculates the Julian Day Number from {@link Millis#epochOfJulian} .
   *
   * @param julianDate the Astronomical Julian Date from {@link Millis#epochOfJulian}
   * @return the Julian Day Number from {@link Millis#epochOfJulian}
   */
  public static long ofUnixDays(final long unixDays) {
    return (long) (((double) unixDays) + Millis.epoch + .5d);
  }

  /**
   * Calculates the Julian Day Number from {@link Millis#epochOfModifiedJulian} .
   *
   * @param modifiedJulianDate the Modified Julian Date from {@link Millis#epochOfModifiedJulian}
   * @return the Julian Day Number from {@link Millis#epochOfModifiedJulian}
   */
  public static long ofModifiedJulian(final double modifiedJulianDate) {
    return ofJulian(modifiedJulianDate);
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param julianDate the Astronomical Julian Date from {@link Millis#epochOfJulian}
   * @return an {@link Instant} represented by specified Astronomical Julian Date from {@link Millis#epochOfJulian}
   */
  public static Instant toInstant(final long julianDayNumber) {
    return Millis.toInstant(Millis.ofJulian(((double) julianDayNumber) -.5d));
  }

  /**
   * JulianDayNumber instances should NOT be constructed in standard programming .
   */
  private JulianDayNumber() {}

  public static void main(String[] args) {
    Instant instant = Instant.from(ZonedDateTime.parse("2017-11-30T00:00:00Z"));
    System.out.println(instant);
    double julian = Julian.ofEpochMillis(instant.toEpochMilli());
    System.out.println(julian);
    Instant instant2 = Julian.toInstant(julian);
    while (instant2.isBefore(ZonedDateTime.parse("2017-12-03T00:00:00Z").toInstant())) {
      System.out.print(instant2);
      System.out.print(" : ");
      System.out.print(ofJulian(Julian.ofEpochMillis(instant2.toEpochMilli())));
      System.out.print(" : ");
      System.out.println(toInstant(ofJulian(Julian.ofEpochMillis(instant2.toEpochMilli()))));
      instant2 = instant2.plus(6, ChronoUnit.HOURS);
    }
    System.out.println(Millis.toInstant(Millis.ofModifiedJulian(51544)));
    System.out.println(Millis.toInstant(1512086400L));

    Instant instant3 = Instant.from(ZonedDateTime.parse("2017-09-09T12:30:45Z"));
    System.out.println(Millis.toUnixDate(instant3.toEpochMilli()));
    System.out.println(Millis.toUnixTime(instant3.toEpochMilli()));

    System.out.println(Instant.ofEpochSecond(Millis.toUnixTime(instant3.toEpochMilli())));

    System.out.println(Instant.ofEpochSecond(Millis.toUnixDate(instant3.toEpochMilli())));
  }
}
