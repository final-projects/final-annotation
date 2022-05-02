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

package org.ifinalframework.core.result;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import org.ifinalframework.core.ResponseStatus;

import lombok.experimental.UtilityClass;

/**
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
@UtilityClass
public class R {
    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {

        return new Result<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getDesc(), data);
    }

    public static <T> Result<T> success(@NonNull String code,
                                        @NonNull String message,
                                        @Nullable T data) {

        return new Result<>(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getDesc(), code, message, data);
    }

    public static <T> Result<T> failure(@NonNull Integer status, @NonNull String description,
                                        @NonNull String code, @NonNull String message) {

        return new Result<>(status, description, code, message);
    }

    public static <T> Result<T> failure(@NonNull Integer status, @NonNull String message) {

        return new Result<>(status, message);
    }

}
