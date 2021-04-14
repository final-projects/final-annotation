package org.ifinal.finalframework.core.annotation;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * A maker superinterface which the {@linkplain Enum enum} should be impl.
 *
 *
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IEnum<T> {

    /**
     * return the {@link IEnum} value of {@code code}.
     *
     * @param type the enum type
     * @param code the enum code
     * @param <T>  enum type
     * @return enum value of code
     */
    @Nullable
    static <T extends IEnum<?>> T valueOf(@Nullable Class<T> type, @Nullable Object code) {
        Objects.requireNonNull(type, "enum type can not be null");

        if (Objects.isNull(code)) {
            return null;
        }

        final T[] constants = type.getEnumConstants();
        for (T constant : constants) {
            if (Objects.equals(constant.getCode(), code)) {
                return constant;
            }
        }
        return null;
    }

    /**
     * return the enum code, not the {@linkplain Enum#ordinal() ordinal}.
     *
     * @return enum code
     */
    @NonNull
    T getCode();

    /**
     * return the enum desc, not the {@linkplain Enum#name() name}.
     *
     * @return enum desc
     */
    @NonNull
    String getDesc();

}