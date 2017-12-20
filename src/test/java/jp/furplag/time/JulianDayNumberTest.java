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

import org.junit.Test;

public class JulianDayNumberTest {

  @Test
  public void test() throws ReflectiveOperationException, SecurityException {
    Constructor<JulianDayNumber> c = JulianDayNumber.class.getDeclaredConstructor();
    c.setAccessible(true);
    assertThat(c.newInstance() instanceof JulianDayNumber, is(true));

    assertThat(JulianDayNumber.ofJulian(Millis.epoch), is(JulianDayNumber.ofEpochMilli(0)));
    assertThat(JulianDayNumber.ofEpochDay(0), is(JulianDayNumber.ofEpochMilli(0)));
    assertThat(JulianDayNumber.ofEpochMilli(Instant.parse("1999-01-01T00:00:00.000Z").toEpochMilli()), is(JulianDayNumber.ofEpochMilli(Instant.parse("1999-01-01T23:59:59.999Z").toEpochMilli())));
  }

  @Test
  public void testOfEpochMillis() {
    assertThat(JulianDayNumber.ofEpochMilli(0), is(((long)(Millis.epoch + .5d))));
    assertThat(JulianDayNumber.ofEpochMilli(Millis.epochOfJulian), is(0L));
  }

  @Test
  public void testOfJulian() {
    assertThat(JulianDayNumber.ofJulian(0), is(0L));
    assertThat(JulianDayNumber.ofJulian(Millis.epoch), is(2440_588L));
  }

  @Test
  public void testOfModifiedJulian() {
    assertThat(JulianDayNumber.ofModifiedJulian(0), is(2400_001L));
    assertThat(JulianDayNumber.ofModifiedJulian(40587.5d), is(2440_588L));
  }

  @Test
  public void testOfEpochDay() {
    assertThat(JulianDayNumber.ofEpochDay(0), is(2440_588L));
    assertThat(JulianDayNumber.ofEpochDay(Millis.toEpochDay(Instant.parse("2000-01-01T00:00:00.000Z").toEpochMilli())), is(((long) (Julian.ofEpochMilli(Instant.parse("2000-01-01T00:00:00.000Z").toEpochMilli()) + .5d))));
  }

  @Test
  public void testToInstant() {
    assertThat(JulianDayNumber.toInstant(0), is(Instant.parse("-4713-11-24T00:00:00.000Z")));
    assertThat(JulianDayNumber.toInstant(2400_001), is(Instant.parse("1858-11-17T00:00:00.000Z")));
    assertThat(JulianDayNumber.toInstant(2440_588), is(Instant.parse("1970-01-01T00:00:00.000Z")));
  }
}
