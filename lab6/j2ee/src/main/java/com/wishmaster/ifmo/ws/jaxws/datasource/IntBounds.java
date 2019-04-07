package com.wishmaster.ifmo.ws.jaxws.datasource;

import java.util.StringJoiner;

public class IntBounds {
    public static final IntBounds EMPTY = new IntBounds(null, null);

    private Integer from;
    private Integer to;

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

    public void setFrom(Integer from) {
        this.from = from;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
            .add("from = " + from)
            .add("to = " + to)
            .toString();
    }
}
