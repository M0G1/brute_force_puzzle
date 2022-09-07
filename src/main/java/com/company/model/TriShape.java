package com.company.model;

import com.company.util.color.Color;
import com.company.util.color.TextColor;

import java.util.Arrays;

import static com.company.util.color.Color.colorize;

/***
 * Triangular shape
 * consist of index.
 */
public class TriShape {
    private Rect outscribedRect;

    private int[][] tri; // filled triangles of shape

    public TriShape() {
    }

    /***
     * @param triangles array with 2 dimensional index. First - row. Second - collumn.
     * */
    public TriShape(int[][] triangles) {
        Arrays.sort(triangles,(o1, o2) -> {
            if (o1[0] - o2[0] != 0)
                return o1[0] - o2[0];
            if (o1[1] - o2[1] != 0)
                return o1[1] - o2[1];
            return 0;
        });
        this.tri = triangles;
        this.outscribedRect = getOutscribedRect(triangles);
    }


    public void recalculateOutscribedRect() {
        outscribedRect = new Rect(0, 0);
    }

    public Rect getOutscribedRect() {
        return outscribedRect;
    }

    private static int[] trasformMatrixIndexToArrayIndex(int[][] triangles) {
        // !!!! realization need
        return new int[]{};
    }

    private static Rect getOutscribedRect(int[][] triangles) {
        int height = Arrays.stream(triangles).mapToInt(el -> el[0]).max().orElse(0);
        int weight = Arrays.stream(triangles).mapToInt(el -> el[1]).max().orElse(0);
        weight = weight > 0 ? weight + 1 : 0; // index to size
        height = height > 0 ? height + 1 : 0; // index to size
        return new Rect(weight, height);
    }

    public int[][] getTri() {
        return tri;
    }

    public void setTri(int[][] tri) {
        this.tri = tri;
    }

}
