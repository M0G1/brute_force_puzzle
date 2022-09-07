package com.company.transformation;

import com.company.model.VecToRot;

import java.util.Arrays;

public class VerticalReflection implements Transformation {
    @Override
    public VecToRot apply(VecToRot vec) {
        int[] newExpansion = Arrays.copyOf(vec.getExpansion(), VecToRot.EXPANSION_COUNT);
        // todo swap positive vertical coefficients and negative vertical coefficients
        assert false : "todo swap positive vertical coefficients and negative vertical coefficients";
        return new VecToRot(newExpansion, !vec.isDown());
    }
}
