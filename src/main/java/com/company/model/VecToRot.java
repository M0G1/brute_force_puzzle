package com.company.model;

import java.util.Arrays;
import java.util.Objects;

public class VecToRot {
    public final static byte EXPANSION_COUNT = 6;
    private int[] expansion; // expansion vector on vector from rotation cycle
    private boolean isDown;

    public VecToRot() {
    }

    public VecToRot(int[] expansion, boolean isDown){
        this.expansion = expansion;
        this.isDown = isDown;
    }

    public int[] getExpansion() {
        return expansion;
    }

    public void setExpansion(int[] expansion) {
        this.expansion = expansion;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VecToRot vecToRot = (VecToRot) o;
        return isDown == vecToRot.isDown && Arrays.equals(expansion, vecToRot.expansion);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(isDown);
        result = 31 * result + Arrays.hashCode(expansion);
        return result;
    }
}
