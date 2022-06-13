package com.company;

import com.company.model.Rect;
import com.company.model.TriShape;
import com.company.util.color.Color;

import java.util.Arrays;
import java.util.List;

import static com.company.util.color.Color.colorize;

public class Drawing {

    public static String evenSubTri = "\\--/";
    public static String evenSubTri2 = "\\/";
    public static String oddSubTri = "/\\";
    public static String oddSubTri2 = "/--\\";

    public static String drawWithFill(List<TriShape> triShapes, List<String> textColor, List<String> backgroundColor) {
        return "";
    }


    public static String draw(TriShape triShape, String textColor, String backgroundColor) {
        int[][] tri = triShape.getTri();
        StringBuilder ans = new StringBuilder(
                triShape.getOutscribedRect().getSquare() * 6 + // triangle str size
                        Arrays.stream(tri).mapToInt(value -> value.length).sum() *
                                (textColor.length() + backgroundColor.length() + Color.RESET.length()) // it may be wrong
        );
        int symPerSubRow = fillStringBuilder(ans, triShape.getOutscribedRect());
        for (int[] ints : tri) {
            int i = ints[0], j = ints[1];
            int fromSub1, fromSub2, toSub1, toSub2;
            int halfJ = j / 2;
            if ((i & 1) == 0) { // odd
                if ((j & 1) == 0) {
                    fromSub1 = halfJ * 4;
                    toSub1 = fromSub1 + 3;
                    fromSub2 = 1 + 4 * halfJ;
                    toSub2 = fromSub2 + 1;
                } else {
                    fromSub1 = 3 + halfJ * 4;
                    toSub1 = fromSub1 + 1;
                    fromSub2 = 2 + 4 * halfJ;
                    toSub2 = fromSub2 + 3;
                }
            } else {
                if ((j & 1) == 0) {
                    fromSub1 = 1 + halfJ * 4;
                    toSub1 = fromSub1 + 1;
                    fromSub2 = 4 * halfJ;
                    toSub2 = fromSub2 + 3;
                } else {
                    fromSub1 = 2 + halfJ * 4;
                    toSub1 = fromSub1 + 3;
                    fromSub2 = 3 + 4 * halfJ;
                    toSub2 = fromSub2 + 1;
                }
            }
            fromSub1 += 2 * i * symPerSubRow;
            fromSub2 += (2 * i + 1) * symPerSubRow;
            toSub1 += (2 * i * symPerSubRow + 1);
            toSub2 += ((2 * i + 1) * symPerSubRow + 1);
            if (((i + j) & 1) == 0) {
                ans.replace(fromSub1, toSub1, evenSubTri);
                ans.replace(fromSub2, toSub2, evenSubTri2);
            } else {
                ans.replace(fromSub1, toSub1, oddSubTri);
                ans.replace(fromSub2, toSub2, oddSubTri2);
            }
        }
        return ans.toString();
    }

    private static int fillStringBuilder(StringBuilder builder, Rect rect) {
        int symPerSubRow = rect.getWeight() * 4 + 2;
        String subRow = " ".repeat(symPerSubRow) + "\n";
        builder.append(subRow.repeat(Math.max(0, rect.getHeight() * 2)));
        return ++symPerSubRow;
    }
}
