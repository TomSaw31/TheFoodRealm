package net.tomsaw31.thefoodrealm.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum SlushyVariant {
    DEFAULT(0),
    BLACK(1);

    private static final SlushyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SlushyVariant::getId)).toArray(SlushyVariant[]::new);
    private final int id;

    SlushyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SlushyVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
