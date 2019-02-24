package com.wishmaster.ifmo.ws.jaxws;

public class Util {
    @FunctionalInterface
    public interface ThrowableBiConsumer<T, U, E extends Throwable> {
        void accept(T t, U u) throws E;
    }
}
