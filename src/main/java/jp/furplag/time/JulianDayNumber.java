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

/**
 * code snippets of astronomical julian day number .
 *
 * @author furplag
 *
 */
public final class JulianDayNumber {

  /**
   * calculates the julian day number from the milliseconds from {@link Millis#epoch} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch}
   * @return the julian day number
   */
  public static long ofEpochMilli(final long epochMilli) {
    return ofJulian(Julian.ofEpochMilli(epochMilli));
  }

  /**
   * calculates the julian day number .
   *
   * @param julianDate the astronomical julian date from {@link Millis#epochOfJulian}
   * @return the julian day number
   */
  public static long ofJulian(final double julianDate) {
    return (long) (julianDate + .5);
  }

  /**
   * calculates the julian day number from {@link Millis#epochOfJulian} .
   *
   * @param modifiedJulianDate the modified julian date from {@link Millis#epochOfModifiedJulian}
   * @return the julian day number
   */
  public static long ofModifiedJulian(final double modifiedJulianDate) {
    return ofJulian(((long) modifiedJulianDate) + Millis.epochOfModifiedJulian);
  }

  /**
   * calculates the julian day number from the days from {@link Millis#epochOfJulian} .
   *
   * @param epochDay the days from {@link Millis#epoch}
   * @return the julian day number
   */
  public static long ofEpochDay(final long epochDay) {
    return (long) (epochDay + Millis.epoch + .5);
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param julianDayNumber the julian day number from the days from {@link Millis#epochOfJulian}
   * @return an {@link Instant} represented by specified julian day number
   */
  public static Instant toInstant(final long julianDayNumber) {
    return Millis.toInstant(Millis.ofJulian(((long) ((double) julianDayNumber) - .5d))).truncatedTo(ChronoUnit.DAYS);
  }

  /**
   * JulianDayNumber instances should NOT be constructed in standard programming .
   */
  private JulianDayNumber() {}
}
