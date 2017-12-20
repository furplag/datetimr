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

/**
 * code snippets of astronomical julian day .
 *
 * @author furplag
 *
 */
public final class Julian {

  /** astronomical julian date of 2001-01-01T12:00:00.000Z. */
  public static final double j2000 = 2451545.0;

  /** the days of julian year. */
  public static final double daysOfYear = 365.25;

  /** delta of the days of a month in the lunar. */
  public static final double incrementOfSynodicMonth = 2.162E-9;

  /** astronomical julian date of 1582-10-15T00:00:00.000Z. */
  public static final double epochOfGregorian = 2299160.5;

  /**
   * calculates the astronomical julian date from {@link Millis#epochOfJulian} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch}
   * @return the astronomical julian date
   */
  public static double ofEpochMilli(final long epochMilli) {
    return (Long.valueOf(epochMilli).doubleValue() / ((double) Millis.ofDay)) + Millis.epoch;
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param julianDate the astronomical julian date
   * @return an {@link Instant} represented by specified astronomical julian date
   */
  public static Instant toInstant(final double julianDate) {
    return Instant.ofEpochMilli(Millis.ofJulian(julianDate));
  }

  /**
   * Julian instances should NOT be constructed in standard programming .
   */
  private Julian() {}
}
