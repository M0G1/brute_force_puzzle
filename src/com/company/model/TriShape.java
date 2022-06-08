package com.company.model;

/***
 * Triangular shape
 * consist of index.
 */
public class TriShape {
    private Rect outscribedRect;
    private int[] triangles; // filled triangles of shape
    private TriShape cwRot = null;  // clock wise rotated
    private TriShape ccwRot = null; // contr clock wise rotated
    private TriShape reflVert = null; // reflected vertically

    public TriShape() {
    }

    /***
     * @param triangles array with 2 dimensional index. First - row. Second - collumn.
     * */
    public TriShape(int[][] triangles) {
        this.triangles = trasformMatrixIndexToArrayIndex(triangles);
        this.outscribedRect = getOutscribedRect(triangles);
    }

    /***
     * @param triangles array with index in matrix.
     * @param outscribedRect size of matrix.
     * */
    public TriShape(int[] triangles, Rect outscribedRect) {
        this.triangles = triangles;
        this.outscribedRect = outscribedRect;
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
        // !!!! realization need
        return new Rect(0, 0);
    }

    public TriShape clockWiseRotate() {
        if (cwRot != null)
            return cwRot;
        // !!!! realization need
        for (int i = 0; i < triangles.length; ++i) {
            i++;
        }
        cwRot = new TriShape();
        return cwRot;
    }

    public TriShape contrClockWiseRotate() {
        if (ccwRot != null)
            return ccwRot;
        // !!!! realization need
        ccwRot = new TriShape();
        return ccwRot;
    }

    public TriShape reflectVertical() {
        if (reflVert != null)
            return reflVert;
        // !!!! realization need
        reflVert = new TriShape();
        return reflVert;
    }
}
