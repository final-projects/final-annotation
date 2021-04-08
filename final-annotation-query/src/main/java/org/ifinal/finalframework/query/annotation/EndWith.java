package org.ifinal.finalframework.query.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Criterion(EndWith.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EndWith {

    String property() default "";

    String[] value() default {
        "<if test=\"${value} != null and ${value} != ''\">",
        "     ${andOr} ${column} LIKE CONCAT(#{${value}},'%') ",
        "</if>"
    };

    Class<?> javaType() default Object.class;

}