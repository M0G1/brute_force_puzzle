import com.company.Drawing;
import com.company.model.TriPos;
import com.company.model.TriShape;
import com.company.pre_defined_shapes.TriShapeChest;
import com.company.util.color.BackColor;
import com.company.util.color.TextColor;
import org.junit.Before;
import org.junit.Test;

public class DrawingTest {


    TriShape shape;

    @Before
    public void setupShape() {
        shape = TriShapeChest.getSingletonFirstShape();
    }

    @Test
    public void drawTest() {
        System.out.println(Drawing.draw(shape, TextColor.BLACK, BackColor.WHITE));
    }

    @Test
    public void unitDrawTest() {
        for (int x = 1; x < 5; ++x) {
            for (int y = 0; y < 5; ++y) {
                TriPos[] triangles = new TriPos[1];
                triangles[0] = new TriPos(x, y);
                System.out.println(Drawing.draw(new TriShape(triangles), TextColor.BLACK, BackColor.WHITE));
                System.out.println();
            }
        }
    }

    @Test
    public void unitOldDrawTest() {
        for (int x = 1; x < 5; ++x) {
            for (int y = 0; y < 5; ++y) {
                TriPos[] triangles = new TriPos[1];
                triangles[0] = new TriPos(x, y);
                System.out.println(Drawing.oldDraw(new TriShape(triangles), TextColor.BLACK, BackColor.WHITE));
                System.out.println();
            }
        }
    }


    @Test
    public void oldDrawTestShapeTest() {
        System.out.println(Drawing.oldDraw(TriShapeChest.getTestShape(), TextColor.BLACK, BackColor.WHITE));

    }

    @Test
    public void drawProblemShapeTest() {
        TriShape shapeCur = new TriShape(new int[][]{
                {2, 0}, {3, 0}
        });
        System.out.println(Drawing.draw(shapeCur, TextColor.BLACK, BackColor.WHITE));
    }
}
