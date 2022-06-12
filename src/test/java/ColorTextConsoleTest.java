import com.company.util.color.BackColor;

import static com.company.util.color.Color.colorize;

import com.company.util.color.Color;
import com.company.util.color.TextColor;
import org.junit.Assert;
import org.junit.Test;

public class ColorTextConsoleTest {

    @Test()
    public void colorTextGenerateExampleTest() {
        System.out.println(colorize(BackColor.GREEN, "This text has a green background but default text!"));
        System.out.println(colorize(TextColor.RED, "This text has red text but a default background!"));
        System.out.println(colorize(BackColor.GREEN + TextColor.RED, "This text has a green background and red text!"));
    }

    @Test
    public void changeColorizedTextLength() {
        String value = "This text has a green background but default text!";
        String color = BackColor.GREEN;
        String newValue = colorize(color, value);
        Assert.assertNotEquals(newValue.length(), value.length());
        System.out.println("" + value.length() + " + " + (color.length() + Color.RESET.length()) + " & " + newValue.length());
        Assert.assertEquals(newValue.length(), value.length() + color.length() + Color.RESET.length());
    }
}
