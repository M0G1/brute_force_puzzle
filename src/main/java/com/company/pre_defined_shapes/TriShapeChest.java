package com.company.pre_defined_shapes;

import com.company.model.TriShape;

public class TriShapeChest {
    public static TriShape first = null;

    public static TriShape getSingletonFirstShape() {
        if (first == null) {
            int[][] firstShapeVal = {                // .01234567890123.
                    {2, 0}, {1, 0}, {3, 0},          // |\  /\--/\     |
                    {1, 1}, {3, 1}, {4, 1}, {5, 1},  // | \/__\/__\    |
                    {4, 2}, {5, 2},                  // | /\--/\--/\--/|
                    {4, 3}, {5, 3},                  // |/  \/  \/__\/ |
                    {3, 4}, {4, 4}                   // |\  /\  /\--/\ |
            };                                       // | \/  \/  \/--\|
            first = new TriShape(firstShapeVal);     // |         /\--/|
            return first;                            // |        /--\/ |
        }                                            // |\  /\  /\--/  |
        return first;
    }

    public static TriShape getTestShape(){
        int[][] firstShapeVal = {
                {1, 0}, {2, 0}, {3, 0}, {4, 0},
                {3, 1}
        };
        return new TriShape(firstShapeVal);
    }
}
