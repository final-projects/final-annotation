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

import org.springframework.lang.NonNull;

import org.ifinalframework.core.Groupable;
import org.ifinalframework.core.IQuery;
import org.ifinalframework.core.Limitable;
import org.ifinalframework.core.Orderable;
import org.ifinalframework.core.Pageable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Class can be used to build a {@linkplain IQuery query} instance from java.
 *
 * <pre class="code">
 *      Query query = new Query.page(page,size)
 *          .where(QProperty.eq.("name"));
 * </pre>
 *
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
public class Query implements IQuery, Pageable, Groupable, Orderable, Limitable, Serializable {

    @Getter
    private final Criteria criteria = new Criteria();

    /**
     * 页码，第一页从1开始
     */
    @Setter
    @Getter
    private Integer page;

    /**
     * 页面容量
     */
    @Setter
    @Getter
    private Integer size;

    /**
     * 是否进行Count查询
     */
    @Setter
    @Getter
    private Boolean count = Boolean.TRUE;

    @Getter
    private Long offset;

    @Getter
    private Long limit;

    @Getter
    private final List<String> orders = new LinkedList<>();

    @Getter
    private final List<String> groups = new LinkedList<>();


    /**
     * set query page and size
     *
     * @param page page
     * @param size size
     * @return query
     */
    public Query page(Integer page, Integer size) {

        this.page = page;
        this.size = size;
        return this;
    }

    /**
     * set query page
     *
     * @param page page
     * @return query
     */
    public Query page(Integer page) {

        this.page = page;
        return this;
    }

    /**
     * set query page size
     *
     * @param size size
     * @return query
     */
    public Query size(Integer size) {

        this.size = size;
        return this;
    }

    /**
     * count
     *
     * @param count count
     * @return query
     */
    public Query count(Boolean count) {

        this.count = count;
        return this;
    }

    /**
     * where
     *
     * @param criteria criteria
     * @return query
     */
    public Query where(@NonNull Criterion... criteria) {
        return where(Arrays.asList(criteria));
    }

    /**
     * where
     *
     * @param criteria criteria
     * @return query
     */
    public Query where(@NonNull Collection<Criterion> criteria) {
        return where(AndOr.AND, criteria);
    }

    public Query where(AndOr andOr, @NonNull Collection<Criterion> criteria) {
        if (AndOr.AND == andOr) {
            this.criteria.addAll(criteria);
        } else {
            this.criteria.add(Criteria.or(criteria));
        }
        return this;
    }

    /**
     * @param properties properties
     * @return query
     */
    public Query group(QProperty<?>... properties) {
        return group(Arrays.asList(properties));
    }

    /**
     * @param properties properties
     * @return query
     */
    public Query group(Collection<QProperty<?>> properties) {
        properties.forEach(it -> this.groups.add(it.getColumn()));
        return this;
    }

    /**
     * @param cloumn cloumn
     * @return query
     */
    public Query group(String... cloumn) {
        this.groups.addAll(Arrays.asList(cloumn));
        return this;
    }

    /**
     * @param orders orders
     * @return query
     */
    public Query sort(@NonNull Order... orders) {
        return sort(Arrays.asList(orders));
    }

    /**
     * @param orders orders
     * @return query
     */
    public Query sort(@NonNull Collection<Order> orders) {

        for (Order order : orders) {
            this.sort(order.getColumn(), order.getDirection());
        }

        return this;
    }

    /**
     * sort
     *
     * @param direction  direction
     * @param properties properties
     * @return query
     */
    public Query sort(@NonNull Direction direction, @NonNull QProperty<?>... properties) {

        for (QProperty<?> property : properties) {
            this.sort(property.getColumn(), direction);
        }

        return this;
    }

    /**
     * ase
     *
     * @param properties properties
     * @return query
     */
    public Query asc(@NonNull QProperty<?>... properties) {
        return sort(Direction.ASC, properties);
    }

    /**
     * desc
     *
     * @param properties properties
     * @return query
     */
    public Query desc(@NonNull QProperty<?>... properties) {
        return sort(Direction.DESC, properties);
    }

    /**
     * sort
     *
     * @param column    column
     * @param direction direction
     */
    private void sort(String column, Direction direction) {
        this.sort(String.format("%s %s", column, direction.name()));
    }

    /**
     * @param order order
     */
    private void sort(String order) {
        this.orders.add(order);
    }

    /**
     * @param offset offset
     * @param limit  limit
     * @return query
     */
    public Query limit(long offset, long limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }

    /**
     * @param limit limit
     * @return query
     */
    public Query limit(long limit) {
        this.offset = null;
        this.limit = limit;
        return this;
    }

}
