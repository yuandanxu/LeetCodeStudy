import LeetCode.P8StringToInteger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by yuand on 2/15/2017.
 */
public class P8Test {
    @Test(dataProvider = "testData")
    public void testP8(int expected, String source) {
        P8StringToInteger p8StringToInteger = new P8StringToInteger();
        System.out.println(expected);
        System.out.println(p8StringToInteger.myAtoi(source));
        Assert.assertEquals(p8StringToInteger.myAtoi(source), expected);
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
            {
                12, "12c"
            },
            {
                -12, "-12C"
            },
            {
                0, "c23"
            },
            {
                10, "   010"
            },
            {
                -10, "   -10"
            },
            {
                2147483648L, "2147483648"
            }
        };
    }
}
