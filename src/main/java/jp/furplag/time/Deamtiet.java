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
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * snippets. DRY, short .
 *
 * @author furplag
 *
 */
interface Deamtiet {

  /**
   * shorthand for converting an {@link Instant} to {@link LocalDateTime} .
   *
   * @param instant {@link Instant}, using {@link Instant#now()} if the value is null
   * @param zoneId {@link ZoneId}, using {@link ZoneId#systemDefault()} if the value is null
   * @return {@link LocalDateTime} represented by specified {@link Instant}
   */
  public static LocalDateTime toLocalDateTime(final Instant instant, final ZoneId zoneId) {
    return ZonedDateTime.ofInstant(Optional.ofNullable(instant).orElseGet(Instant::now), Optional.ofNullable(zoneId).orElseGet(ZoneId::systemDefault)).toLocalDateTime();
  }
}
