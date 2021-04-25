/*
 * Copyright 2020-2021 the original author or authors.
 *
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
 *
 */

package org.ifinal.finalframework.data.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Marked the element is a {@literal virtual} property, it's value generated by a {@linkplain Json json}. A {@linkplain
 * Virtual} column is normal annotated on a {@linkplain Method getter} method.
 *
 * <pre class="code">
 *      ALTER TABLE {tableName} ADD {virtual column name} {virtual column type}
 *      GENERATED ALWAYS AS JSON_UNQUOTE({column}-&gt;{path});
 * </pre>
 *
 * @author likly
 * @version 1.0.0
 * @see Column
 * @see Prefix
 * @since 1.0.0
 */
@Prefix("v_")
@Column
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Virtual {

    @AliasFor(annotation = Column.class)
    String value() default "";

    @AliasFor(annotation = Column.class)
    String name() default "";

}
