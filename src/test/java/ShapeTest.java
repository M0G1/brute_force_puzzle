import com.company.Drawing;
import com.company.model.Rect;
import com.company.model.TriShape;
import com.company.model.VecToRot;
import com.company.pre_defined_shapes.TriShapeChest;
import com.company.transformation.ShapeClockWiseRotation;
import com.company.util.color.BackColor;
import com.company.util.color.TextColor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ShapeTest {

    TriShape shape;
    /*













     */

    @Before
    public void setupShape() {
        shape = TriShapeChest.getSingletonFirstShape();
    }

    @Test
    public void rectTest() {
        Assert.assertEquals(shape.getOutscribedRect(), new Rect(6, 5));
    }


    @Test
    public void sortTest() {
        int[][] shapeVal = {
                {2, 0}, {1, 0}, {3, 0},
                {1, 1}, {3, 1}, {4, 1}, {5, 1},
                {4, 2}, {5, 2},
                {4, 3}, {5, 3},
                {3, 4}, {4, 4}
        };
        TriShape newShape = new TriShape(shapeVal);
        boolean isEquals = Arrays.deepEquals(newShape.getPoses(), shape.getPoses());
        if (!isEquals) {
            System.out.println(Arrays.deepToString(shapeVal));
            System.out.println(Arrays.deepToString(shape.getPoses()));
        }
        Assert.assertTrue(isEquals);
    }

    @Test
    public void drawTest2() {
        System.out.println(Drawing.draw(TriShapeChest.getTestShape(), TextColor.BLACK, BackColor.WHITE));
    }

    @Test
    public void simpleRotationTest(){
        TriShape test = TriShapeChest.getTestShape();
        TriShape newTest = new ShapeClockWiseRotation().apply(test);
        System.out.println(Drawing.draw(test, TextColor.BLACK, BackColor.WHITE));
        System.out.println(Drawing.draw(newTest, TextColor.BLACK, BackColor.WHITE));
    }
    @Test
    public void complexRotationTest(){
        TriShape test = TriShapeChest.getTestShape();
        System.out.println(test);
        System.out.println(Drawing.draw(test, TextColor.BLACK, BackColor.WHITE));

        for(int i =0 ; i< VecToRot.EXPANSION_COUNT;++i){
            test = new ShapeClockWiseRotation().apply(test);
            System.out.println(test);
            System.out.println(Drawing.draw(test, TextColor.BLACK, BackColor.WHITE));
        }
    }
}
