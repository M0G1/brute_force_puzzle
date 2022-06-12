package com.company.util.color;

public class Color {
    public static final String RESET = "\u001B[0m";

    public static String colorize(String color, String value) {
        return color + value + RESET;
    }

    public static void appendColorized(String color, StringBuilder builder, String value) {
        builder.append(color).append(value).append(RESET);
    }

    public static void replaceColorized(String color, StringBuilder builder, int start, int end, String value) {
        builder.replace(start, end, value);
        builder.insert(end, RESET);
        builder.insert(start, color);
    }
}
