package com.company.transformation;

import com.company.model.TriPos;
import com.company.model.TriShape;

public interface ShapeTransformation {
    TriShape apply(TriShape shape);
}
