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

package org.ifinalframework.core;

import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * A interface for data holder should be impl which provide the method of {@link #getData()}/{@link #setData(Object)} to
 * get/set the data which could be {@literal null}.
 *
 *
 * @author ilikly
 * @version 1.0.0
 * @see IResult
 * @see IPage
 * @since 1.0.0
 */
public interface IData<T> extends Serializable {

    /**
     * return the data which may be {@literal null}.
     *
     * @return the data hold.
     */
    @Nullable
    T getData();

    /**
     * set the data which could be {@literal null}
     *
     * @param data the data to hold.
     */
    void setData(@Nullable T data);

}
