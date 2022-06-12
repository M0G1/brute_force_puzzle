import com.company.Drawing;
import com.company.model.TriShape;
import com.company.util.color.BackColor;
import com.company.util.color.TextColor;
import org.junit.Before;
import org.junit.Test;

public class ShapeTest {

    TriShape shape;
    /*
    ._______________.
    |\  /\--/\      |
    | \/__\/__\     |
    | /\--/\--/\--/ |
    |/  \/  \/__\/  |
    |\  /\  /\--/\  |
    | \/  \/  \/--\ |
    |         /\--/ |
    |        /--\/  |
    |\  /\  /\--/   |
    | \/  \/--\/    |
    |_______________|
    */

    @Before
    public void setupShape() {
        int[][] shapeVal = {
                {0, 1}, {0, 2}, {0, 3},
                {1, 1}, {1, 3}, {1, 4}, {1, 5},
                {2, 4}, {1, 5},
                {3, 4}, {3, 5},
                {4, 3}, {3, 4}
        };
        shape = new TriShape(shapeVal);
    }

    @Test
    public void drawTest() {
        System.out.println(Drawing.draw(shape, TextColor.RED, BackColor.BLACK));
    }
}
