package com.company.model;

import java.util.Objects;

import static java.lang.Math.abs;

public final class TriPos {
    private final short x;
    private final short y;

    public TriPos(int x, int y) {
        this.x = (short) (x >> 16 ^ x); // save sign
        this.y = (short) (y >> 16 ^ y); // save sign
    }

    public TriPos(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public TriPos sum(TriPos triPos){
        return new TriPos(this.x + triPos.x, this.y + triPos.y);
    }

    public TriPos sum(int x, int y){
        return new TriPos(this.x + x, this.y + y);
    }

    public static TriPos sum(TriPos first, TriPos second) {
        return new TriPos(first.x + second.x, first.y + second.y);
    }

    public static TriPos sub(TriPos reduced, TriPos subtrahend) {
        return new TriPos(reduced.x - subtrahend.x, reduced.y + subtrahend.y);
    }

    public static TriPos mul(int c, TriPos vec) {
        return new TriPos(c * vec.x, c * vec.y);
    }

    public static TriPos ZERO_ZERO = new TriPos(0, 0);

    public boolean isDown() {
        return ((abs(x) + abs(y)) ^ 1) == 0; // is Even
    }

    public short getX() {
        return x;
    }

    public short getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriPos triPos = (TriPos) o;
        return x == triPos.x && y == triPos.y;
    }

    @Override
    public int hashCode() {
        return x << 16 + y; // own realization
    }
}
