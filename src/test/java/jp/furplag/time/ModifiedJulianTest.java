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

public class ModifiedJulianTest {

  @Test
  public void test() throws ReflectiveOperationException, SecurityException {
    Constructor<ModifiedJulian> c = ModifiedJulian.class.getDeclaredConstructor();
    c.setAccessible(true);
    assertThat(c.newInstance() instanceof ModifiedJulian, is(true));
  }

  @Test
  public void testOfEpochMillis() {
    assertThat(ModifiedJulian.ofEpochMillis(Instant.parse("1858-11-17T00:00:00.000Z").toEpochMilli()), is(0d));
    assertThat(ModifiedJulian.ofEpochMillis(Instant.parse("2000-01-01T00:00:00Z").toEpochMilli()), is(51_544d));
  }

  @Test
  public void testOfToInstant() {
    assertThat(ModifiedJulian.toInstant(0), is(Instant.parse("1858-11-17T00:00:00.000Z")));
  }
}
