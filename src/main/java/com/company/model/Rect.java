package com.company.model;

import java.util.Objects;

/***
 * Rectangle
 */
public class Rect {
    private int weight;
    private int height;
    private int square;

    public Rect(int weight, int height) {
        this.weight = Math.max(weight, 1);
        this.height = Math.max(height, 1);
        this.square = weight * height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getSquare() {
        return square;
    }

    public void setWeight(int weight) {
        this.weight = weight;
        this.square = height * weight;
    }

    public void setHeight(int height) {
        this.height = height;
        this.square = height * weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rect rect = (Rect) o;
        return square == rect.square && weight == rect.weight && height == rect.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }
}
