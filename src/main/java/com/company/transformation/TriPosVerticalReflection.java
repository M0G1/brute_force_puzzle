package com.company.transformation;

import com.company.model.VecToRot;

import java.util.Arrays;

import static com.company.Converter.VERT_NEG_IND;
import static com.company.Converter.VERT_POS_IND;

public class TriPosVerticalReflection implements TriPosTransformation {
    @Override
    public VecToRot apply(VecToRot vec) {
        int[] newExpansion = Arrays.copyOf(vec.getExpansion(), VecToRot.EXPANSION_COUNT);
        // swap positive vertical coefficients and negative vertical coefficients
        newExpansion[VERT_POS_IND] ^= newExpansion[VERT_NEG_IND];
        newExpansion[VERT_NEG_IND] ^= newExpansion[VERT_POS_IND];
        newExpansion[VERT_POS_IND] ^= newExpansion[VERT_NEG_IND];
        return new VecToRot(newExpansion, !vec.isDown());
    }
}
