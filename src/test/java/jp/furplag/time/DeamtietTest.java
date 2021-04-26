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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import org.junit.Test;

public class DeamtietTest implements Deamtiet {

  @SuppressWarnings("deprecation")
  @Test
  public void test() {
    assertThat(Duration.between(Deamtiet.toLocalDateTime(null, null), LocalDateTime.now()).get(ChronoUnit.SECONDS), is(0L));
    final Instant currentMillis = Instant.ofEpochMilli(System.currentTimeMillis());
    ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).forEach(z -> {
      assertThat(Duration.between(Deamtiet.toLocalDateTime(null, z), ZonedDateTime.now(z).toLocalDateTime()).get(ChronoUnit.SECONDS), is(0L));
      assertThat(Deamtiet.toLocalDateTime(currentMillis, null), is(ZonedDateTime.ofInstant(currentMillis, ZoneId.systemDefault()).toLocalDateTime()));
      assertThat(Duration.between(Deamtiet.toLocalDateTime(currentMillis, z), ZonedDateTime.ofInstant(currentMillis, z).toLocalDateTime()).get(ChronoUnit.SECONDS), is(0L));
    });
    IntStream.rangeClosed(-10000, 10000).boxed().forEach(i -> {
      assertThat(Deamtiet.toLocalDateTime(Millis.toInstant(i * Millis.ofDay), null), is(ZonedDateTime.ofInstant(Instant.ofEpochMilli(i * Millis.ofDay), ZoneId.systemDefault()).toLocalDateTime()));
    });
  }
}
