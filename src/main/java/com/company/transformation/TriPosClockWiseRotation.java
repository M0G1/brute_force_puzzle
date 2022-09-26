package com.company.transformation;

import com.company.model.VecToRot;

public class TriPosClockWiseRotation implements TriPosTransformation {
    @Override
    public VecToRot apply(VecToRot vec) {
        int[] expansion = vec.getExpansion();
        int[] newExpansion = new int[VecToRot.EXPANSION_COUNT];
        for (int i = 0; i < VecToRot.EXPANSION_COUNT; ++i)
            newExpansion[(i + 1) % VecToRot.EXPANSION_COUNT] = expansion[i];
        return new VecToRot(newExpansion, !vec.isDown());
    }
}
