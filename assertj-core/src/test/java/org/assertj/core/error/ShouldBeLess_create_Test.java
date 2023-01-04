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
import static org.assertj.core.error.ShouldBeLess.shouldBeLess;

import org.assertj.core.description.TextDescription;
import org.assertj.core.internal.ComparatorBasedComparisonStrategy;
import org.assertj.core.presentation.StandardRepresentation;
import org.assertj.core.util.AbsValueComparator;
import org.junit.jupiter.api.Test;

/**
 * Tests for
 * <code>{@link ShouldBeLess#create(org.assertj.core.description.Description, org.assertj.core.presentation.Representation)}</code>
 * .
 *
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
class ShouldBeLess_create_Test {

  @Test
  void should_create_error_message() {
    // GIVEN
    ErrorMessageFactory factory = shouldBeLess(8, 6);
    // WHEN
    String message = factory.create(new TextDescription("Test"), new StandardRepresentation());
    // THEN
    then(message).isEqualTo(format("[Test] %n" +
                                   "Expecting actual:%n" +
                                   "  8%n" +
                                   "to be less than:%n" +
                                   "  6 "));
  }

  @Test
  void should_create_error_message_with_custom_comparison_strategy() {
    // GIVEN
    ErrorMessageFactory factory = shouldBeLess(8, 6, new ComparatorBasedComparisonStrategy(new AbsValueComparator<Integer>()));
    // WHEN
    String message = factory.create(new TextDescription("Test"), new StandardRepresentation());
    // THEN
    then(message).isEqualTo(format("[Test] %n" +
                                   "Expecting actual:%n" +
                                   "  8%n" +
                                   "to be less than:%n" +
                                   "  6 when comparing values using AbsValueComparator"));
  }
}
