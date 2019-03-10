package com.wishmaster.ifmo.ws.jaxws.datasource;

import java.util.StringJoiner;

public class IntBounds {
    public static final IntBounds EMPTY = new IntBounds(null, null);

    public final Integer from;
    public final Integer to;

    public IntBounds(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public IntBounds() {
        this(null, null);
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
            .add("from = " + from)
            .add("to = " + to)
            .toString();
    }
}
