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

package org.ifinalframework.query.condition;

import org.ifinalframework.query.Criterion;
import org.ifinalframework.query.CriterionExpression;

/**
 * NullCondition.
 *
 * @author likly
 * @version 1.0.0
 * @see org.ifinalframework.query.annotation.IsNull
 * @see org.ifinalframework.query.annotation.IsNotNull
 * @since 1.0.0
 */
public interface NullCondition extends Condition {

    /**
     * {@code column IS NULL}
     *
     * @return criterion
     * @see org.ifinalframework.query.annotation.IsNull
     */
    default Criterion isNull() {
        return condition(CriterionExpression.IS_NULL, Object.class);
    }

    /**
     * {@code column IS NOT NULL}
     *
     * @return criterion
     * @see org.ifinalframework.query.annotation.IsNotNull
     */
    default Criterion isNotNull() {
        return condition(CriterionExpression.IS_NOT_NULL, Object.class);
    }

}
