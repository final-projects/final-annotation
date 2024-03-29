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

package org.ifinalframework.data.annotation;

import org.ifinalframework.core.lang.Default;

import java.lang.annotation.*;

/**
 * A marker annotation to annotated the {@link PrimaryKey} use auto incr.
 *
 * <pre class="code">
 *      public interface Mapper{
 *          &#64;Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
 *          public int insert(IEntity entity)
 *      }
 * </pre>
 *
 * @author iimik
 * @version 1.0.0
 * @see PrimaryKey
 * @see org.apache.ibatis.annotations.Options
 * @since 1.0.0
 */
@Default
@Documented
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInc {

}
