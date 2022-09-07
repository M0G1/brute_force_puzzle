import com.company.Drawing;
import com.company.model.Rect;
import com.company.model.TriShape;
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
    public void setupShape() {                   //     .01234567890123.
        int[][] shapeVal = {                     //     |\  /\--/\     |
                {0, 1}, {0, 2}, {0, 3},          //     | \/__\/__\    |
                {1, 1}, {1, 3}, {1, 4}, {1, 5},  //     | /\--/\--/\--/|
                {2, 4}, {2, 5},                  //     |/  \/  \/__\/ |
                {3, 4}, {3, 5},                  //     |\  /\  /\--/\ |
                {4, 3}, {4, 4}                   //     | \/  \/  \/--\|
        };                                       //     |         /\--/|
        shape = new TriShape(shapeVal);          //     |        /--\/ |
    }                                            //     |\  /\  /\--/  |
    //     | \/  \/--\/   |
    //     |______________|

    @Test
    public void rectTest() {
        Assert.assertEquals(shape.getOutscribedRect(), new Rect(6, 5));
    }

    @Test
    public void drawTest() {
        System.out.println(Drawing.draw(shape, TextColor.BLACK, BackColor.WHITE));
    }

    @Test
    public void sortTest() {
        int[][] shapeVal = {
                {0, 2}, {0, 1}, {0, 3},
                {1, 1}, {1, 3}, {1, 4}, {1, 5},
                {2, 4}, {2, 5},
                {3, 4}, {3, 5},
                {4, 3}, {4, 4}
        };
        TriShape newShape = new TriShape(shapeVal);
        boolean isEquals = Arrays.deepEquals(newShape.getTri(), shape.getTri());
        if (!isEquals) {
            System.out.println(Arrays.deepToString(shapeVal));
            System.out.println(Arrays.deepToString(shape.getTri()));
        }
        Assert.assertTrue(isEquals);

    }
}
