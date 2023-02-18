/*
 * Copyright 2020-2023 the original author or authors.
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

package org.ifinalframework.data.spi;

import org.springframework.lang.NonNull;

/**
 * PreInsertFilter.
 *
 * @author ilikly
 * @version 1.4.3
 * @since 1.4.3
 */
@FunctionalInterface
public interface PreInsertFilter<T, U> {
    /**
     * test the entity with user.
     *
     * @param entity the entity to test.
     * @param user   the current user.
     * @return true if the entity matched.
     */
    boolean test(@NonNull T entity, @NonNull U user);
}

