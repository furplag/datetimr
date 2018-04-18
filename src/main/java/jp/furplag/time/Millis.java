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
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * code snippets of timestamp .
 *
 * @author furplag
 *
 */
public final class Millis {

  /** the millis of one day. */
  public static final long ofDay = 864_000_00L;

  /** the epoch astronomical julian date of 1970-01-01T00:00:00.000Z. */
  public static final double epoch = 2_440_587.5d;

  /** the epoch millis of -4713-11-24T12:00:00.000Z. */
  public static final long epochOfJulian = -210_866_760_000_000L;

  /** the epoch modified julian date of 1858-11-17T00:00:00.000Z. */
  public static final double epochOfModifiedJulian = 2_400_000.5d;

  /** the epoch millis of 1582-10-15T00:00:00.000Z. */
  public static final long epochOfGregorian = -12_219_292_800_000L;

  /**
   * calculates the epoch millis from {@link Millis#epoch epoch} .
   *
   * @param julianDate the astronomical julian date
   * @return milliseconds of that have elapsed since {@link Millis#epoch epoch}
   */
  public static long ofJulian(final double julianDate) {
    return Double.valueOf((julianDate - Millis.epoch) * Millis.ofDay).longValue();
  }

  /**
   * calculates the epoch millis from {@link Millis#epoch epoch} .
   *
   * @param modifiedJulianDate the modified julian date from {@link Millis#epochOfModifiedJulian}
   * @return the epoch millis from {@link Millis#epoch epoch}
   */
  public static long ofModifiedJulian(final double modifiedJulianDate) {
    return ofJulian(modifiedJulianDate + Millis.epochOfModifiedJulian);
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch epoch}
   * @return an {@link Instant} represented by specified epoch milliseconds from {@link Millis#epoch epoch}
   */
  public static Instant toInstant(final long epochMilli) {
    return Instant.ofEpochMilli(epochMilli);
  }

  /**
   * calculates the days that have elapsed since {@link Millis#epoch epoch} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch epoch}
   * @return the days that have elapsed since {@link Millis#epoch epoch}
   */
  public static long toEpochDay(final long epochMilli) {
    return epochMilli / Millis.ofDay;
  }

  /**
   * calculates the seconds that have elapsed since {@link Millis#epoch epoch} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch epoch}
   * @return the seconds that have elapsed since {@link Millis#epoch epoch}
   */
  public static long toEpochSecond(final long epochMilli) {
    return epochMilli / 1000L;
  }

  /**
   * shorthand for {@code ZonedDateTime.ofInstant(Millis.toInstant(epochMilli), ZoneId.systemDefault()).toLocalDateTime()} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch epoch}
   * @return {@link LocalDateTime}
   */
  public static LocalDateTime toLocalDateTime(final long epochMilli) {
    return Deamtiet.toLocalDateTime(toInstant(epochMilli), null);
  }

  /**
   * shorthand for {@code ZonedDateTime.ofInstant(Millis.toInstant(epochMilli), ZoneId.systemDefault()).toLocalDateTime()} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch epoch}
   * @param zoneId {@link ZoneId}
   * @return {@link LocalDateTime}
   */
  public static LocalDateTime toLocalDateTime(final long epochMilli, final ZoneId zoneId) {
    return Deamtiet.toLocalDateTime(toInstant(epochMilli), zoneId);
  }

  /**
   * Millis instances should NOT be constructed in standard programming .
   */
  private Millis() {}
}
