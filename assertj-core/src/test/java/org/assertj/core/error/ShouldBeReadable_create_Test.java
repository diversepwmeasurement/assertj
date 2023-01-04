/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2023 the original author or authors.
 */
package org.assertj.core.error;

import static java.lang.String.format;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.error.ShouldBeReadable.SHOULD_BE_READABLE;
import static org.assertj.core.error.ShouldBeReadable.shouldBeReadable;
import static org.mockito.Mockito.mock;

import java.nio.file.Path;

import org.assertj.core.internal.TestDescription;
import org.assertj.core.presentation.StandardRepresentation;
import org.junit.jupiter.api.Test;

class ShouldBeReadable_create_Test {

  private static final TestDescription TEST_DESCRIPTION = new TestDescription("Test");
  private static final StandardRepresentation STANDARD_REPRESENTATION = new StandardRepresentation();

  @Test
  void should_create_error_message_for_File() {
    // GIVEN
    FakeFile file = new FakeFile("xyz");
    ErrorMessageFactory factory = shouldBeReadable(file);
    // WHEN
    String message = factory.create(TEST_DESCRIPTION, STANDARD_REPRESENTATION);
    // THEN
    then(message).isEqualTo(format("[Test] " + SHOULD_BE_READABLE, file));
  }

  @Test
  void should_create_error_message_for_Path() {
    // GIVEN
    final Path path = mock(Path.class);
    ErrorMessageFactory factory = shouldBeReadable(path);
    // WHEN
    String message = factory.create(TEST_DESCRIPTION, STANDARD_REPRESENTATION);
    // THEN
    then(message).isEqualTo(format("[Test] " + SHOULD_BE_READABLE, path));
  }
}
