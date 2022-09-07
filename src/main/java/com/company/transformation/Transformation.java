package com.company.transformation;

import com.company.model.VecToRot;

public interface Transformation {
    VecToRot apply(VecToRot vec);
}
