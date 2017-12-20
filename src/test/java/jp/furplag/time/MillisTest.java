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

import java.lang.reflect.Constructor;
import java.time.Instant;
import java.time.ZonedDateTime;

import org.junit.Test;

public class MillisTest {

  @Test
  public void test() throws ReflectiveOperationException, SecurityException {
    Constructor<Millis> c = Millis.class.getDeclaredConstructor();
    c.setAccessible(true);
    assertThat(c.newInstance() instanceof Millis, is(true));
  }

  @Test
  public void testOfJulian() {
    assertThat(Millis.ofJulian(0), is(Millis.epochOfJulian));
    assertThat(Millis.ofJulian(0), is(Instant.from(ZonedDateTime.parse("-4713-11-24T12:00:00Z")).toEpochMilli()));
  }

  @Test
  public void testOfModifiedJulian() {
    assertThat(Millis.ofModifiedJulian(0), is(Instant.from(ZonedDateTime.parse("1858-11-17T00:00:00Z")).toEpochMilli()));
    assertThat(Instant.ofEpochMilli(Millis.ofModifiedJulian(36_115.791_66666d)), is(Instant.from(ZonedDateTime.parse("1957-10-04T19:00:00Z"))));
    assertThat(Instant.ofEpochMilli(Millis.ofModifiedJulian(51_544d)), is(Instant.from(ZonedDateTime.parse("2000-01-01T00:00:00Z"))));
  }

  @Test
  public void testToInstant() {
    assertThat(Millis.toInstant(0), is(Instant.from(ZonedDateTime.parse("1970-01-01T00:00:00Z"))));
    assertThat(Millis.toInstant(Millis.epochOfGregorian), is(Instant.from(ZonedDateTime.parse("1582-10-15T00:00Z"))));
  }

  @Test
  public void testToUnixDay() {
    assertThat(Millis.toEpochDay(0), is(0L));
    assertThat(Millis.toEpochDay(12345), is(0L));
    assertThat(Millis.toEpochDay(12345L * 86400_000), is(12345L));
  }

  @Test
  public void testToUnixTime() {
    assertThat(Millis.toEpochSecond(0), is(0L));
    assertThat(Millis.toEpochSecond(12345), is(12L));
    assertThat(Millis.toEpochSecond(12345L * 1000), is(12345L));
  }
}
