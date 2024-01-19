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

package org.ifinalframework.data.annotation.criterion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

import org.ifinalframework.data.query.BetweenValue;
import org.ifinalframework.data.query.QProperty;

/**
 * <pre class="code">
 *     column BETWEEN #{min} AND #{max}
 * </pre>
 *
 * @author iimik
 * @version 1.0.0
 * @see QProperty#between(Object, Object)
 * @see BetweenValue
 * @see NotBetween
 * @since 1.0.0
 */
@Documented
@Criterion({
        "<if test=\"${value} != null and ${value}.min != null and ${value}.max != null\">",
        "    <![CDATA[",
        "       ${andOr} ${column} BETWEEN #{${value}.min",
        "           #if($javaType),javaType=$!{javaType.canonicalName}#end",
        "           #if($typeHandler),typeHandler=$!{typeHandler.canonicalName}#end}",
        "       AND #{${value}.max",
        "           #if($javaType),javaType=$!{javaType.canonicalName}#end",
        "           #if($typeHandler),typeHandler=$!{typeHandler.canonicalName}#end}",
        "       ]]>",
        "</if>"
})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Between {

    /**
     * property name
     *
     * @return property name
     */
    @AliasFor(annotation = Criterion.class)
    String property() default "";

    @AliasFor(annotation = Criterion.class, value = "property")
    String value() default "";

    /**
     * java type
     *
     * @return java type
     */
    @AliasFor(annotation = Criterion.class)
    Class<?> javaType() default Object.class;

}
