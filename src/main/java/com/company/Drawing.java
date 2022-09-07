package com.company;

import com.company.model.Rect;
import com.company.model.TriShape;
import com.company.util.color.BackColor;
import com.company.util.color.Color;
import com.company.util.color.TextColor;

import java.util.Arrays;
import java.util.List;

import static com.company.util.color.Color.colorize;

public class Drawing {
    public static String bColor = BackColor.WHITE;
    public static String tColor = TextColor.BLACK;
    public static String oneColorizedSymbol = tColor + bColor + " " + Color.RESET;
    public static String widePattern = oneColorizedSymbol +
            tColor + bColor + "  " + Color.RESET + // 2 colorized symbols
            oneColorizedSymbol;
    public static int oCSL = oneColorizedSymbol.length();
    public static int wPL = widePattern.length();
    public static int oCSPos = (tColor + bColor).length() + 1;
    public static int tCSL = (tColor + bColor + "  " + Color.RESET).length(); // 2 colorized symbol length


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
                    fromSub1 = halfJ * wPL;
                    toSub1 = fromSub1 + wPL;
                    fromSub2 = oCSL + wPL * halfJ;
                    toSub2 = fromSub2 + 2 * oCSL;
                } else {
                    fromSub1 = wPL - oCSL + halfJ * wPL;
                    toSub1 = fromSub1 + 2 * oCSL;
                    fromSub2 = 2 * oCSL + wPL * halfJ;
                    toSub2 = fromSub2 + wPL;
                }
            } else {
                if ((j & 1) == 0) {
                    fromSub1 = oCSL + wPL * halfJ;
                    toSub1 = fromSub1 + 2 * oCSL;
                    fromSub2 = wPL * halfJ;
                    toSub2 = fromSub2 + wPL;
                } else {
                    fromSub1 = 2 * oCSL + wPL * halfJ;
                    toSub1 = fromSub1 + wPL;
                    fromSub2 = wPL - oCSL + halfJ * wPL;
                    toSub2 = fromSub2 + 2 * oCSL;
                }
            }
            fromSub1 += 2 * i * symPerSubRow;
            fromSub2 += (2 * i + 1) * symPerSubRow;
            toSub1 += (2 * i * symPerSubRow);
            toSub2 += ((2 * i + 1) * symPerSubRow);
            if (((i + j) & 1) == 0) {
                ans.replace(fromSub1, toSub1, getColorizedEvenSubTri(textColor, backgroundColor));
                ans.replace(fromSub2, toSub2, getColorizedEvenSubTri2(textColor, backgroundColor));
            } else {
                ans.replace(fromSub1, toSub1, getColorizedOddSubTri(textColor, backgroundColor));
                ans.replace(fromSub2, toSub2, getColorizedOddSubTri2(textColor, backgroundColor));
            }
        }
        return ans.toString();
    }

    private static int fillStringBuilder(StringBuilder builder, Rect rect) {
        int blockCnt = Math.round((float) rect.getWeight() / 2);
        String repeatedPart = widePattern.repeat(blockCnt);
        String twoColorizedSym = oneColorizedSymbol + oneColorizedSymbol;
        String oddSubRow = repeatedPart + twoColorizedSym + "\n";
        String evenSubRow = twoColorizedSym + repeatedPart + "\n";
        String oddRow = oddSubRow + evenSubRow;
        String evenRow = evenSubRow + oddSubRow;
        builder.append((oddRow + evenRow).repeat(rect.getHeight() / 2));
        if ((rect.getHeight() & 1) != 0)
            builder.append(oddRow);
        return oddSubRow.length(); // symbol per subRow
    }

    private static String getColorizedEvenSubTri(String textColor, String backgroundColor) {
        String color = textColor + backgroundColor;
        return Color.colorize(color, "\\") +
                Color.colorize(color, "--") +
                Color.colorize(color, "/");
    }

    private static String getColorizedEvenSubTri2(String textColor, String backgroundColor) {
        String color = textColor + backgroundColor;
        return Color.colorize(color, "\\") +
                Color.colorize(color, "/");
    }

    private static String getColorizedOddSubTri(String textColor, String backgroundColor) {
        String color = textColor + backgroundColor;
        return Color.colorize(color, "/") +
                Color.colorize(color, "\\");
    }

    private static String getColorizedOddSubTri2(String textColor, String backgroundColor) {
        String color = textColor + backgroundColor;
        return Color.colorize(color, "/") +
                Color.colorize(color, "--") +
                Color.colorize(color, "\\");
    }

}
