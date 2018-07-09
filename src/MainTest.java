import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    lib test =new lib();
    @Test
    public void isZTest() {
        char a = 'a';
        char b = 'Z';
        char c = ' ';
        char d = '1';
        Assert.assertTrue(test.isZ(a));
        Assert.assertTrue(test.isZ(b));
        Assert.assertFalse(test.isZ(c));
        Assert.assertFalse(test.isZ(d));

    }

    @Test
    public void isNumberTest() {
        char a = '1';
        char b = '8';
        char c = ' ';
        char d = 'a';
        Assert.assertTrue(test.isNumber(a));
        Assert.assertTrue(test.isNumber(b));
        Assert.assertFalse(test.isNumber(c));
        Assert.assertFalse(test.isNumber(d));
    }

    @Test
    public void isSplitTest() {
        char a = '1';
        char b = '8';
        char c = ' ';
        char d = 'a';
        char e = ',';
        char f = '.';
        Assert.assertFalse(test.isSplit(a));
        Assert.assertFalse(test.isSplit(b));
        Assert.assertTrue(test.isSplit(c));
        Assert.assertFalse(test.isSplit(d));
        Assert.assertTrue(test.isSplit(e));
        Assert.assertTrue(test.isSplit(f));
    }

    @Test
    public void dealFileTest() {
        String[] args = {"test.txt"};
        test.dealFile(args);
        Assert.assertTrue(test.getMap1().get("t") == 54);
        Assert.assertTrue(test.getMap2().get("that") == 3);
    }
}