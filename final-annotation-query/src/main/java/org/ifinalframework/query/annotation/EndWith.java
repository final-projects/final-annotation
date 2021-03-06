/*
 * Copyright 2020-2021 the original author or authors.
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

package org.ifinalframework.query.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author likly
 * @version 1.0.0
 * @see EndsWith
 * @since 1.0.0
 * @deprecated replaced by {@link EndsWith}
 */
@Deprecated
@Criterion(EndWith.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EndWith {

    String property() default "";

    String[] value() default {
        "<if test=\"${value} != null and ${value} != ''\">",
        "     ${andOr} ${column} LIKE CONCAT(#{${value}},'%') ",
        "</if>"
    };

    Class<?> javaType() default Object.class;

}
