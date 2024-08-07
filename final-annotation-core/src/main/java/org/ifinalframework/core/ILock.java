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

package org.ifinalframework.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ILock.
 *
 * @author iimik
 * @version 1.5.0
 * @since 1.5.0
 */
public interface ILock {
    /**
     * 设置锁定状态
     * @param locked
     */
    void setLocked(Boolean locked);

    /**
     * 获取锁定状态
     * @return
     */
    Boolean getLocked();

    /**
     * 是否锁定
     * @return
     */
    @JsonIgnore
    default boolean isLocked(){
        return Boolean.TRUE.equals(getLocked());
    }
}
