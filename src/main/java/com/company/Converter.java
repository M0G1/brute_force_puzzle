package com.company;

import com.company.model.TriPos;
import com.company.model.VecToRot;

public class Converter {

    public static final TriPos[] rotCycle = { // rotation Cycle
            new TriPos(1, 0),  // isDown = true
            new TriPos(1, 0),  // isDown = false
            new TriPos(0, -1), // isDown = true
            new TriPos(-1, 0), // isDown = false
            new TriPos(-1, 0), // isDown = true
            new TriPos(0, 1)   // isDown = false
    };

    public static VecToRot triPositions2VecToRot(TriPos start, TriPos end) {
        TriPos vector = TriPos.sub(start, end);
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
        assert false : "no realization";
        if (isDown && vec.getX() > 0) {
            // todo подумать какие соотносятся с rotCycle
        } else if (isDown && vec.getX() < 0) {

        } else if (!isDown && vec.getX() > 0) {

        } else if (!isDown && vec.getX() < 0) {

        }

        ans.setExpansion(new int[]{}); // todo незабыть вписать
        return ans;
    }

    public static TriPos TriPosPlusVecToRot(TriPos start, VecToRot vec) {
        TriPos ans = TriPos.ZERO_ZERO;
        for (int i = 0; i < VecToRot.EXPANSION_COUNT; ++i) {
            int coeff = vec.getExpansion()[i];
            TriPos mul = TriPos.mul(coeff, rotCycle[i]);
            ans = TriPos.sum(ans, mul);
        }
        return ans;
    }
}
