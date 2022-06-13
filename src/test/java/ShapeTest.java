import com.company.Drawing;
import com.company.model.TriShape;
import com.company.util.color.BackColor;
import com.company.util.color.TextColor;
import org.junit.Before;
import org.junit.Test;

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
    @Test                                        //     |______________|
    public void drawTest() {
        System.out.println(Drawing.draw(shape, TextColor.RED, BackColor.BLACK));
    }
}
