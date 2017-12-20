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
 * code snippets of modified julian date .
 *
 * @author furplag
 *
 */
public class ModifiedJulian {

  /**
   * calculates the modified julian date from {@link Millis#epochOfModifiedJulian} .
   *
   * @param epochMilli the epoch millis from {@link Millis#epoch}
   * @return the modified julian date from {@link Millis#epochOfModifiedJulian}
   */
  public static double ofEpochMilli(final long epochMilli) {
    return Julian.ofEpochMilli(epochMilli) - Millis.epochOfModifiedJulian;
  }

  /**
   * substitute for {@link Instant#ofEpochMilli(long)} .
   *
   * @param modifiedJulianDate the modified julian date
   * @return an {@link Instant} represented by specified modified julian date from {@link Millis#epochOfModifiedJulian}
   */
  public static Instant toInstant(final double modifiedJulianDate) {
    return Instant.ofEpochMilli(Millis.ofModifiedJulian(modifiedJulianDate));
  }

  /**
   * ModifiedJulian instances should NOT be constructed in standard programming .
   */
  private ModifiedJulian() {}
}
