package com.company.transformation;

import com.company.model.VecToRot;

public interface TriPosTransformation {
    VecToRot apply(VecToRot vec);
}
