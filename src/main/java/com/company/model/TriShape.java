package com.company.model;

import java.util.Arrays;
import java.util.Comparator;

/***
 * Triangular shape
 * consist of index.
 */
public class TriShape {
    private Rect outscribedRect;

    private TriPos[] poses; // filled triangles of shape

    public TriShape() {
    }

    public TriShape(int[][] triangles) {
        this(TriPos.toObject(triangles));
    }

    /***
     * @param triangles array with 2 dimensional index. First - row. Second - collumn.
     * */
    public TriShape(TriPos[] triangles) {
        this.poses = TriShape.shiftIfNeed(triangles); // triangles; //
        this.outscribedRect = getOutscribedRect(triangles);
    }

    public void recalculateOutscribedRect() {
        outscribedRect = new Rect(0, 0);
    }

    public Rect getOutscribedRect() {
        return outscribedRect;
    }

    @Override
    public String toString() {
        return "TriShape{" + "outscribedRect=" + outscribedRect + ", poses=" + Arrays.toString(poses) + '}';
    }

    private static int[] trasformMatrixIndexToArrayIndex(int[][] triangles) {
        // !!!! realization need
        assert false : "No realization";
        return new int[]{};
    }

    private static Rect getOutscribedRect(TriPos[] triangles) {
        int height = Arrays.stream(triangles).mapToInt(TriPos::getY).max().orElse(0);
        int weight = Arrays.stream(triangles).mapToInt(TriPos::getX).max().orElse(0);
        weight = weight > 0 ? weight + 1 : 0; // index to size
        height = height > 0 ? height + 1 : 0; // index to size
        return new Rect(weight, height);
    }

    public static TriPos[] shiftIfNeed(TriPos[] triangles) {
        int XShift = Arrays.stream(triangles).mapToInt(TriPos::getX).min().orElse(0);
        int YShift = Arrays.stream(triangles).mapToInt(TriPos::getY).min().orElse(0);

        if (isNeedShift(XShift, YShift)) {
            TriPos shift = new TriPos(-(XShift & -2), -YShift); // shift by x is multiple 2
            for (int i = 0; i < triangles.length; ++i) {
                triangles[i] = triangles[i].sum(shift);
            }
        }
        return triangles;
    }

    public static boolean isNeedShift(int XShift, int YShift) {
        return XShift < 0 || YShift < 0 ; // || XShift > 1 || YShift > 0
    }

    public TriPos[] getPoses() {
        return poses;
    }

    public int[][] getTri() {
        return TriPos.toIntegers(poses);
    }

    public void setPoses(TriPos[] poses) {
        this.poses = poses;
    }


}
