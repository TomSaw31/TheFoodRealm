package net.tomsaw31.thefoodrealm.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum CuptoiseVariant {
    PINK(0),
    YELLOW(1),
    BLUE(2);

    private static final CuptoiseVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(CuptoiseVariant::getId)).toArray(CuptoiseVariant[]::new);
    private final int id;

    CuptoiseVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CuptoiseVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
