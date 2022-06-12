package com.company;

import com.company.model.TriShape;
import com.company.util.color.Color;

import java.util.Arrays;
import java.util.List;

import static com.company.util.color.Color.colorize;

public class Drawing {
    public static String fillingStr = "--"; // string what will be placed into triangle. Must have size = 2

    private enum aShapeState {
        empty, // предыдущий треугольник - пустой
        longEmpty, // несколько предыдущих треугольников - пустые
        odd, // предыдущий треугольный элемент закрашен и нечетный
        even // предыдущий треугольный элемент закрашен и четный
    }

    public static String drawWithFill(List<TriShape> triShapes, List<String> textColor, List<String> backgroundColor){
        return "";
    }

    @Deprecated
    public static String draw(TriShape triShape, String textColor, String backgroundColor) {
        int[][] tri = triShape.getTri();
        StringBuilder ans = new StringBuilder(
                triShape.getOutscribedRect().getSquare() * 6 + // triangle str size
                        Arrays.stream(tri).mapToInt(value -> value.length).sum() *
                                (textColor.length() + backgroundColor.length() + Color.RESET.length()) // it may be wrong
        );
        StringBuilder first, second;
        for (int i = 0; i < tri.length; ++i) {
            first = new StringBuilder((i & 1) == 0 ? "" : " "); // выставляем первый символ для отступа
            second = new StringBuilder((i & 1) == 0 ? " " : "");
            int j = 0, ind = 0; // индекс треугольного элемента в матрице и индекс в массиве треугльных элементов фигруы
            while (ind < tri[i].length) {
                int nextTriInd = tri[i][ind]; // индекс следующего треугольного элемента для закраски
                if (nextTriInd > j) // добавляем пустые треугольники
                    addEmptyTriangles(i, j, nextTriInd, first, second);
                j = nextTriInd;
                if (((i + j) & 1) == 0)
                    addEvenFilledTriangle(first, second, textColor, backgroundColor);
                else
                    addOddFilledTriangle(first, second, textColor, backgroundColor);
                ++ind;
            }
            first.append("\n");
            second.append("\n");
            ans.append(first).append(second);
        }
        return ans.toString();
    }

    @Deprecated
    private static void addOddFilledTriangle(StringBuilder first, StringBuilder second, String textColor, String backgroundColor) {
        if (!(first.lastIndexOf("/") == first.length() - 1
                && second.lastIndexOf("/") == second.length() - 1)) {
            first.append(colorize(textColor, "/"));
            second.append(colorize(textColor, "/"));
        }
        second.append(colorize(textColor + backgroundColor, fillingStr));
        first.append(colorize(textColor, "\\"));
        second.append(colorize(textColor, "\\"));
    }

    @Deprecated
    private static void addEvenFilledTriangle(StringBuilder first, StringBuilder second, String textColor, String backgroundColor) {
        if (!(first.lastIndexOf("\\") == first.length() - 1
                && second.lastIndexOf("\\") == second.length() - 1)) {
            first.append(colorize(textColor, "\\"));
            second.append(colorize(textColor, "\\"));
        }
        first.append(colorize(textColor + backgroundColor, fillingStr));
        first.append(colorize(textColor, "/"));
        second.append(colorize(textColor, "/"));
    }

    @Deprecated
    private static void addEmptyTriangles(int i, int j, int nextTriInd, StringBuilder first, StringBuilder second) {
        nextTriInd -= 1; // специальная обработка для последнего треуготольного элемента
        int diff = nextTriInd - j;
        if (diff > 1) {
            int parallelogramCnt = diff / 2;
            String parallelogramEmpty = " ".repeat(parallelogramCnt * 5);
            first.append(parallelogramEmpty);
            second.append(parallelogramEmpty);
            if (parallelogramCnt * 2 < diff) {
                int lastFullElInd = diff - 1; // parallelogramCnt * 2 + 1 must be same ??
                boolean isEven = ((lastFullElInd + i) & 1) == 0;
                first.append(isEven ? "   " : " ");
                second.append(isEven ? " " : "   ");
            }
        }else {
            first.append(" ");
            second.append(" ");
        }
        boolean isEven = ((nextTriInd + i) & 1) == 0;
        first.append(isEven ? "  " : "");
        second.append(isEven ? "" : "  ");
    }

}
