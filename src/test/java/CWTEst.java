import com.company.Converter;
import com.company.Drawing;
import com.company.model.TriPos;
import com.company.model.TriShape;
import com.company.model.VecToRot;
import com.company.transformation.TriPosClockWiseRotation;
import com.company.util.color.BackColor;
import com.company.util.color.TextColor;
import org.junit.Test;
import org.junit.Assert;

public class CWTEst {

    public int[] getVecToRotBasisCoeffs(int index) {
        int[] coeffs = new int[VecToRot.EXPANSION_COUNT];
        coeffs[index % VecToRot.EXPANSION_COUNT] = 1;
        return coeffs;
    }

    @Test
    public void simpleRotation() {
        TriPos start = new TriPos(1, 0);
        TriPos end = new TriPos(2, 0);
        for (int i = 0; i < VecToRot.EXPANSION_COUNT; ++i) {
            System.out.printf("Iteration %d%n", i);
            System.out.println(start);
            System.out.println(end);
//            System.out.println(Drawing.draw(new TriShape(new TriPos[]{start, end}), TextColor.BLACK, BackColor.WHITE));

            VecToRot cwRot = Converter.triPositions2VecToRot(start, end);

            System.out.println(cwRot);
            VecToRot newCWRotPos = new TriPosClockWiseRotation().apply(cwRot);
            System.out.println(newCWRotPos);

            Assert.assertArrayEquals(
                    getVecToRotBasisCoeffs(i),
                    cwRot.getExpansion()
            );


            start = new TriPos(
                    (start.getX() + 1),
                    start.getY()
            );
            end = Converter.TriPosPlusVecToRot(start, newCWRotPos);
            System.out.println(start);
            System.out.println(end);
            System.out.println();

//            System.out.println(Drawing.oldDraw(new TriShape(new TriPos[]{start, end}), TextColor.BLACK, BackColor.WHITE));
        }
    }

    @Test
    public void simpleRotationProblemIteration() {
        TriPos start = new TriPos(2, 0);
        TriPos end = new TriPos(4, 1);
        int i = 3;
        System.out.printf("Iteration %d%n", i);
        System.out.println(start);
        System.out.println(end);

        VecToRot cwRot = Converter.triPositions2VecToRot(start, end);

        System.out.println(cwRot);
        VecToRot newCWRotPos = new TriPosClockWiseRotation().apply(cwRot);
        System.out.println(newCWRotPos);

//        Assert.assertArrayEquals(
//                getVecToRotBasisCoeffs(i),
//                cwRot.getExpansion()
//        );


        start = new TriPos(
                (start.getX() + 1),
                start.getY()
        );
        end = Converter.TriPosPlusVecToRot(start, newCWRotPos);
        System.out.println(start);
        System.out.println(end);
        System.out.println();
    }


}
