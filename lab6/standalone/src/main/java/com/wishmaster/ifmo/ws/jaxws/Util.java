package com.wishmaster.ifmo.ws.jaxws;

public class Util {
    @FunctionalInterface
    public interface ThrowableBiConsumer<T, U, E extends Throwable> {
        void accept(T t, U u) throws E;
    }

    public static <T> T firstNonNull(T t1, T t2) {
        return t1 == null ? t2 : t1;
    }
}
