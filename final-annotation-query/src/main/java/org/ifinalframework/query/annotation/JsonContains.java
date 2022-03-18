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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generate sql fragment like {@code JSON_CONTAINS(${column},'${value}'[,'${path}']})}
 *
 * @author ilikly
 * @version 1.0.0
 * @see NotJsonContains
 * @see org.ifinalframework.query.condition.JsonCondition#jsonContains(Object)
 * @since 1.0.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Criterion(JsonContains.class)
public @interface JsonContains {

    /**
     * property name
     * @return property nam
     */
    String property() default "";

    /**
     * value
     * @return value
     */
    String[] value() default {
        "<if test=\"${value} != null\">",
        "   <![CDATA[",
        "       ${andOr} JSON_CONTAINS( ${column}, #{${value}",
        "           #if($javaType), javaType=$!{javaType.canonicalName}#end",
        "           #if($typeHandler), typeHandler=$!{typeHandler.canonicalName}#end}",
        "       #if($path), '${path}'#end)",
        "   ]]>",
        "</if>"
    };

    /**
     * path
     * @return path
     */
    String path() default "";

    /**
     * java type
     * @return javaType
     */
    Class<?> javaType() default Object.class;

}
