package com.company.model;

import com.company.Converter;

import java.util.Arrays;
import java.util.Objects;

public class VecToRot {
    public final static byte EXPANSION_COUNT = 6;
    private int[] expansion; // expansion vector on vector from rotation cycle
    private boolean isDown;

    public VecToRot() {
        this(new int[]{0, 0, 0, 0, 0, 0}, false);
    }

    public VecToRot(int[] expansion) {
        this(expansion, false);
    }

    public VecToRot(boolean isDown) {
        this(new int[]{0, 0, 0, 0, 0, 0}, isDown);
    }

    public VecToRot(int[] expansion, boolean isDown) {
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

    @Override
    public String toString() {
        return "VecToRot{" +
                "expansion=" + Arrays.toString(expansion) +
                ", isDown=" + isDown +
                "} " + Converter.TriPosPlusVecToRot(TriPos.ZERO_ZERO, this);
    }

    public VecToRot sum(VecToRot second) {
        return new VecToRot(new int[]{
                this.expansion[0] + second.expansion[0],
                this.expansion[1] + second.expansion[1],
                this.expansion[2] + second.expansion[2],
                this.expansion[3] + second.expansion[3],
                this.expansion[4] + second.expansion[4],
                this.expansion[5] + second.expansion[5],
        });
    }
}
