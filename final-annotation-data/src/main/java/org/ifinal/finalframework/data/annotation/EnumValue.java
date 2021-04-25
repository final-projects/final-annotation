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

import org.ifinal.finalframework.core.IEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotate the bean {@linkplain java.lang.reflect.Field property} is a {@link Enum} which will be serialized some ext property in json,
 * such as {@literal xxxName} and {@literal xxxDesc}.
 *
 * @author likly
 * @version 1.0.0
 * @see IEnum
 * @since 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValue {

    /**
     * 枚举类型
     *
     * @return the Enum value
     */
    @SuppressWarnings("rawtypes")
    Class<? extends Enum> value();

    /**
     * return the static {@linkplain java.lang.reflect.Method creator} name of target {@link Enum}.
     *
     * @return the static creator method name.
     */
    String creator() default "valueOf";

    /**
     * return the {@linkplain Class parameter} type of the static {@linkplain java.lang.reflect.Method creator}.
     *
     * @return the parameter type.
     * @see Class#getMethod(String, Class[])
     */
    Class<?> valueType() default Integer.class;

    /**
     * 序列化时增加的枚举描述对应的枚举属性
     *
     * @return desc
     */
    String desc() default "desc";

}
