package jp.furplag.time;

import java.time.Instant;

/**
 * code snippets of Modified Julian Date .
 *
 * @author furplag
 *
 */
public class ModifiedJulian {

  /**
   * ModifiedJulian instances should NOT be constructed in standard programming .
   */
  private ModifiedJulian() {}

  /**
   * Calculates the Modified Julian Date from {@link Millis#epochOfModifiedJulian} .
   *
   * @param the epoch millis from {@link Millis#epoch}
   * @return the Modified Julian Date from {@link Millis#epochOfModifiedJulian}
   */
  public static double ofEpochMillis(final long epochMillis) {
    return Julian.ofEpochMillis(epochMillis) + Millis.epochOfModifiedJulian;
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param modifiedJulianDate the Modified Julian Date from {@link Millis#epochOfModifiedJulian}
   * @return an {@link Instant} represented by specified Astronomical Julian Date from {@link Millis#epochOfModifiedJulian}
   */
  public static Instant toInstant(final double modifiedJulianDate) {
    return Instant.ofEpochMilli(Millis.ofModifiedJulian(modifiedJulianDate));
  }
}
