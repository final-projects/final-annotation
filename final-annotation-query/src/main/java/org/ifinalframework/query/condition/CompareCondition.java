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

import org.springframework.lang.Nullable;

import org.ifinalframework.query.Criterion;
import org.ifinalframework.query.CriterionAttributes;
import org.ifinalframework.query.CriterionExpression;

import java.util.function.Consumer;

/**
 * CompareCondition.
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CompareCondition<V> extends Condition {

    /**
     * Build a {@code eq} criterion for {@code column = #{value}}.
     *
     * @param value value.
     * @return a {@code eq} criterion.
     * @see org.ifinalframework.query.annotation.Equal
     */
    default Criterion eq(@Nullable V value) {
        return eq(value, null);
    }

    /**
     * @param value
     * @param consumer
     * @return
     * @since 1.2.1
     */
    default Criterion eq(@Nullable V value, @Nullable Consumer<CriterionAttributes> consumer) {
        return condition(CriterionExpression.EQUAL, value, consumer);
    }

    default Criterion neq(@Nullable V value) {
        return neq(value, null);
    }

    /**
     * Build a {@code neq} criterion for {@code column != #{value}}.
     *
     * @param value value.
     * @return a {@code neq} criterion.
     * @see org.ifinalframework.query.annotation.NotEqual
     * @since 1.2.1
     */
    default Criterion neq(@Nullable V value, @Nullable Consumer<CriterionAttributes> consumer) {
        return condition(CriterionExpression.NOT_EQUAL, value, consumer);
    }

    /**
     * Build a {@code gt} criterion for {@code column > #{value}}.
     *
     * @param value value.
     * @return a {@code gt} criterion.
     * @see org.ifinalframework.query.annotation.GreatThan
     */
    default Criterion gt(@Nullable V value, @Nullable Consumer<CriterionAttributes> consumer) {
        return condition(CriterionExpression.GREAT_THAN, value, consumer);
    }

    default Criterion gt(@Nullable V value) {
        return gt(value, null);
    }

    /**
     * Build a {@code geq} criterion for sql {@code column >= #{value}}
     *
     * @param value value.
     * @return a {@code geq} criterion.
     * @since 1.2.1
     */
    default Criterion geq(@Nullable V value, @Nullable Consumer<CriterionAttributes> consumer) {
        return condition(CriterionExpression.GREAT_THAN_EQUAL, value, consumer);
    }

    default Criterion geq(@Nullable V value) {
        return geq(value, null);
    }

    /**
     * Build a {@code gte} criterion for {@code column >= #{value}}.
     *
     * @param value value.
     * @return a {@code gte} criterion.
     * @see org.ifinalframework.query.annotation.GreatThanEqual
     * @see #geq(Object)
     */
    @Deprecated
    default Criterion gte(@Nullable V value) {
        return geq(value);
    }

    /**
     * Build a {@code lt} criterion for {@code column < #{value}}.
     *
     * @param value value
     * @return a {@code lt} criterion.
     * @see org.ifinalframework.query.annotation.LessThan
     */
    default Criterion lt(@Nullable V value, @Nullable Consumer<CriterionAttributes> consumer) {
        return condition(CriterionExpression.LESS_THAN, value, consumer);
    }

    default Criterion lt(@Nullable V value) {
        return lt(value, null);
    }

    /**
     * Build a {@code lte} criterion for {@code column <= #{value}}.
     *
     * @param value value.
     * @return a {@code leq} criterion.
     * @see org.ifinalframework.query.annotation.LessThanEqual
     * @since 1.2.1
     */
    default Criterion leq(@Nullable V value, @Nullable Consumer<CriterionAttributes> consumer) {
        return condition(CriterionExpression.LESS_THAN_EQUAL, value, consumer);
    }

    default Criterion leq(@Nullable V value) {
        return leq(value, null);
    }

    /**
     * @see #leq(Object)
     * @deprecated replaced by {@code let()}
     */
    @Deprecated
    default Criterion lte(@Nullable V value) {
        return leq(value);
    }

    /**
     * Build a {@link Criterion} like {@link #lt(Object)}
     *
     * @param value value.
     * @return a criterion.
     * @see #lt(Object)
     */
    default Criterion before(@Nullable V value) {
        return lt(value);
    }

    /**
     * Build a {@link Criterion} like {@link #gt(Object)}
     *
     * @param value value.
     * @return a criterion.
     * @see #gt(Object)
     */
    default Criterion after(@Nullable V value) {
        return gt(value);
    }

}
