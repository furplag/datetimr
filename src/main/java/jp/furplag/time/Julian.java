package jp.furplag.time;

import java.time.Instant;

/**
 * code snippets of Astronomical Julian Date .
 *
 * @author furplag
 *
 */
public final class Julian {

  /**
   * Calculates the Astronomical Julian Date from {@link Millis#epochOfJulian} .
   *
   * @param the epoch millis from {@link Millis#epoch}
   * @return the Astronomical Julian Date from {@link Millis#epochOfJulian}
   */
  public static double ofEpochMillis(final long epochMillis) {
    return (Long.valueOf(epochMillis).doubleValue() / ((double) Millis.ofDay)) + Millis.epoch;
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param julianDate the Astronomical Julian Date from {@link Millis#epochOfJulian}
   * @return an {@link Instant} represented by specified Astronomical Julian Date from {@link Millis#epochOfJulian}
   */
  public static Instant toInstant(final double julianDate) {
    return Instant.ofEpochMilli(Millis.ofJulian(julianDate));
  }

  /**
   * Julian instances should NOT be constructed in standard programming .
   */
  private Julian() {}
}
