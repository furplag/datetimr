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

public class JulianTest {

  @Test
  public void test() throws ReflectiveOperationException, SecurityException {
    Constructor<Julian> c = Julian.class.getDeclaredConstructor();
    c.setAccessible(true);
    assertThat(c.newInstance() instanceof Julian, is(true));
  }

  @Test
  public void testOfEpochMillis() {
    assertThat(Julian.ofEpochMilli(0), is(Millis.epoch));
    assertThat(Julian.ofEpochMilli(Millis.epochOfJulian), is(0d));
  }

  @Test
  public void testOfToInstant() {
    assertThat(Julian.toInstant(0), is(Instant.parse("-4713-11-24T12:00:00.000Z")));
  }
}
