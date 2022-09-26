package com.company.transformation;

import com.company.Converter;
import com.company.model.TriPos;
import com.company.model.TriShape;
import com.company.model.VecToRot;

public class ShapeClockWiseRotation implements ShapeTransformation {

    public TriPosClockWiseRotation cwRotation = new TriPosClockWiseRotation();

    @Override
    public TriShape apply(TriShape shape) {
        // Не получится создать фигру последовательным поворотом.
        // Потому что существует больше 1 способа пройти из Start в End
        // Инвариант здесь такой - полседовательность цифр с учетом циклического сдвига должен оставаться - неизменным!
        // [2, 1, 0, 0, 0, 0] - всегда последовательность [2, 1],
        // но в процессе последовательного поворота, приходя к значению [0, 2, 1, 0, 0, 0] она может стать [1, 1, 1, 0, 0, 0]
        // потому что оба описывают вектор [2, 1].
        // Нужно идти по фигуре, чтобы сохранять.
        TriPos[] triangles = shape.getPoses();
        TriPos[] newTriangles = new TriPos[triangles.length];
        TriPos start = triangles[0];

        // shift right on 1
        newTriangles[0] = new TriPos(
                start.getX() + 1,
                start.getY()
        );

        TriPos newStart = newTriangles[0];

        for (int i = 1; i < triangles.length; ++i) {
            VecToRot vec = Converter.triPositions2VecToRot(triangles, i);
            System.out.print(vec + "  ");
            vec = cwRotation.apply(vec);
            System.out.println(vec);
            TriPos newUnit = Converter.TriPosPlusVecToRot(newStart, vec);
            newTriangles[i] = newUnit;
        }

        return new TriShape(newTriangles);
    }
}
