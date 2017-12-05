/**
 * Copyright (C) 2017+ furplag (https://github.com/furplag)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.furplag.time;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public final class JulianDayNumber {

  /**
   * Calculates the Julian Day Number from the milliseconds from {@link Millis#epoch} .
   *
   * @param the epoch millis from {@link Millis#epoch}
   * @return the Julian Day Number from {@link Millis#epochOfJulian}
   */
  public static long ofEpochMillis(final long epochMillis) {
    return ofJulian(Julian.ofEpochMillis(epochMillis));
  }

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
   * Calculates the Julian Day Number from {@link Millis#epochOfModifiedJulian} .
   *
   * @param modifiedJulianDate the Modified Julian Date from {@link Millis#epochOfModifiedJulian}
   * @return the Julian Day Number from {@link Millis#epochOfModifiedJulian}
   */
  public static long ofModifiedJulian(final double modifiedJulianDate) {
    return ofJulian(modifiedJulianDate + ((long) Millis.epochOfModifiedJulian));
  }

  /**
   * Calculates the Julian Day Number from the days from {@link Millis#epoch} .
   *
   * @param julianDate the Astronomical Julian Date from {@link Millis#epochOfJulian}
   * @return the Julian Day Number from {@link Millis#epochOfJulian}
   */
  public static long ofUnixDays(final long unixDays) {
    return (long) (((double) unixDays) + Millis.epoch + .5d);
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param julianDate the Astronomical Julian Date from {@link Millis#epochOfJulian}
   * @return an {@link Instant} represented by specified Astronomical Julian Date from {@link Millis#epochOfJulian}
   */
  public static Instant toInstant(final long julianDayNumber) {
    return Millis.toInstant(Millis.ofJulian(((long) ((double) julianDayNumber) - .5d))).truncatedTo(ChronoUnit.DAYS);
  }

  /**
   * JulianDayNumber instances should NOT be constructed in standard programming .
   */
  private JulianDayNumber() {}
}
