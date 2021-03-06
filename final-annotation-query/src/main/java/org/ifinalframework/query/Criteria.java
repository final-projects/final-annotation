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

package org.ifinalframework.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Criteria.
 *
 * <h4>Criteria And</h4>
 * Use {@link Criteria} build {@code and} sql like {@code A AND B AND C}.
 * <pre class="code">
 * Criteria.where(A,B,C);
 * // or
 * Criteria.and(A,B,C);
 * </pre>
 *
 * <h4>Criteria Or</h4>
 * Use {@link Criteria} build a {@code or} sql like {@code A OR B OR C}.
 * <pre class="code">
 * Criteria.or(A,B,C);
 * </pre>
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
public class Criteria extends ArrayList<Criterion> implements Criterion {

    @Getter
    private final AndOr andOr;

    public Criteria() {
        this(AndOr.AND);
    }

    public Criteria(final AndOr andOr) {
        this.andOr = andOr;
    }

    /**
     * @param andOr    criteria andOr.
     * @param criteria criteria.
     * @throws NullPointerException if the {@code andOr} or {@code criteria} is null.
     */
    public Criteria(final AndOr andOr, Collection<Criterion> criteria) {
        this.andOr = Objects.requireNonNull(andOr, "Criteria andOr can not be null.");
        this.addAll(Objects.requireNonNull(criteria));
    }

    public static Criteria where(Criterion... criterion) {
        return and(criterion);
    }

    public static Criteria where(Collection<Criterion> criterion) {
        return and(criterion);
    }

    public static Criteria and(Criterion... criterion) {
        return and(Arrays.asList(criterion));
    }

    public static Criteria and(Collection<Criterion> criterion) {
        return new Criteria(AndOr.AND, criterion);
    }

    public static Criteria or(Criterion... criterion) {
        return or(Arrays.asList(criterion));
    }

    public static Criteria or(Collection<Criterion> criterion) {
        return new Criteria(AndOr.OR, criterion);
    }

    public Criteria and(final Criteria... criteria) {

        return andOr(AndOr.AND, criteria);
    }

    public Criteria or(final Criteria... criteria) {

        return andOr(AndOr.OR, criteria);
    }

    private Criteria andOr(final AndOr andOr, final Criteria... criteria) {
        List<Criterion> list = new ArrayList<>();
        list.add(this);
        list.addAll(Arrays.asList(criteria));
        return new Criteria(andOr, list);
    }

}
