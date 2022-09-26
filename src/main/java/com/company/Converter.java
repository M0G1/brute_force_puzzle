package com.company;

import com.company.model.TriPos;
import com.company.model.VecToRot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    public static int VERT_POS_IND = 5;
    public static int VERT_NEG_IND = 3;

    public static final TriPos[] rotCycle = { // rotation Cycle
            new TriPos(1, 0),  // isDown = true
            new TriPos(1, 0),  // isDown = false
            new TriPos(0, 1), // isDown = true
            new TriPos((short) -1, 0), // isDown = false
            new TriPos((short) -1, 0), // isDown = true
            new TriPos(0, (short) -1)   // isDown = false
    };

    public static VecToRot triPositions2VecToRot(TriPos start, TriPos end) {
        TriPos vector = TriPos.sub(end, start);
        return triPosVec2VecToRot(start.isDown(), vector);
    }


    // todo memorization of function search for it
    private static VecToRot triPosVec2VecToRot(boolean isDown, TriPos vec) {
        VecToRot ans = new VecToRot();
        ans.setDown(isDown);
        int[] coeffs = new int[VecToRot.EXPANSION_COUNT];
        int pos_odd = 0;  // positive
        int pos_even = 0;
        int neg_odd = 0;
        int neg_even = 0;
        int pos_vert = vec.getY() > 0 ? vec.getY() : 0;
        int neg_vert = vec.getY() < 0 ? -vec.getY() : 0;

        int x = Math.abs(vec.getX());

        if (isDown && vec.getX() > 0) {
            // todo подумать какие соотносятся с rotCycle
            pos_odd = x / 2;
            pos_even = x - pos_odd;
        } else if (isDown && vec.getX() < 0) {
            neg_odd = x / 2;
            neg_even = x - neg_odd;
        } else if (!isDown && vec.getX() > 0) {
            pos_even = x / 2;
            pos_odd = x - pos_even;
        } else if (!isDown && vec.getX() < 0) {
            neg_even = x / 2;
            neg_odd = x - neg_even;
        }
        // synchronization with VERT_POS_IND, VERT_NEG_IND
        ans.setExpansion(new int[]{pos_odd, pos_even, pos_vert, neg_even, neg_odd, neg_vert}); // todo незабыть вписать
        return ans;
    }

    public static TriPos TriPosPlusVecToRot(TriPos start, VecToRot vec) {
        TriPos ans = start;
        for (int i = 0; i < VecToRot.EXPANSION_COUNT; ++i) {
            int coeff = vec.getExpansion()[i];
            TriPos mul = TriPos.mul(coeff, rotCycle[i]);
            ans = TriPos.sum(ans, mul);
        }
        return ans;
    }


    public static VecToRot triPositions2VecToRot(TriPos[] triangles, int index) {
        List<TriPos> triPosList = new ArrayList<>(List.of(triangles));
        TriPos curPos = triangles[0];
        TriPos end = triangles[index];
        TriPos vector = TriPos.sub(end, curPos);
        int[] vec = new int[]{vector.getX(), vector.getY()};

        int[] decXY = new int[]{
                vector.getX() != 0 ? -vec[0] / Math.abs(vec[0]) : 0,
                vector.getY() != 0 ? -vec[1] / Math.abs(vec[1]) : 0
        };
        TriPos[] steps = new TriPos[]{
                new TriPos(-decXY[0], 0),
                new TriPos(0, -decXY[1])
        };
        System.out.print(triPosList);
        System.out.print("    ");
        System.out.println(index);
//        System.out.println(Arrays.toString(decXY));
//        System.out.println(triPosList);

        VecToRot ans = new VecToRot();

        while (vec[0] > 0 || vec[1] > 0) {
            int dimInd = -1;
            int indexTri = -1;
            for (int dim = 0; dim < decXY.length; ++dim) {
                TriPos possibleToExist = curPos.sum(steps[dim]);
//                System.out.println(possibleToExist);
                indexTri = triPosList.indexOf(possibleToExist);
                if (indexTri != -1 && vec[dim] > 0) {
                    dimInd = dim;
                    break;
                }
            }
            System.out.printf("dimInd: %d, indexTri: %s, CurPos: %s, Vector: %s", dimInd, triangles[indexTri], curPos, vector);
            VecToRot vecByStep = triPositions2VecToRot(curPos, triangles[indexTri]);
            ans = ans.sum(vecByStep);
            vec[dimInd] += decXY[dimInd];
            curPos = triangles[indexTri];
        }
        ans.setDown(triangles[0].isDown());
        return ans;
    }


}
