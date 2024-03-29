/*
 * Copyright 2020-2022 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ifinalframework.data.annotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SqlKeyWordsTest.
 *
 * @author iimik
 * @version 1.4.2
 * @since 1.4.2
 */
class SqlKeyWordsTest {

    @ParameterizedTest
    @ValueSource(strings = {"key", "order", "group", "source", "user"})
    void isKeyWord(String word) {
        assertTrue(SqlKeyWords.isKeyWord(word));
        assertTrue(SqlKeyWords.contains(word));
    }
}