import Sword.FindInPartiallySortedMatrix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by yuand on 2/14/2017.
 */
public class TestFindInPartiallySortedMatrix {
    @Test(dataProvider = "positive")
    public void postiveTests(String testDataIndex, Integer[][] testData){
        FindInPartiallySortedMatrix findInPartiallySortedMatrix = new FindInPartiallySortedMatrix();
        boolean result = findInPartiallySortedMatrix.findInPartiallySortedMatrix(testData, 5);
        Assert.assertTrue(result, testDataIndex + "Didn't find the result");
    }

    @Test(dataProvider = "negative")
    public void negativeTests(String testDataIndex, Integer[][] testData){
        FindInPartiallySortedMatrix findInPartiallySortedMatrix = new FindInPartiallySortedMatrix();
        boolean result = findInPartiallySortedMatrix.findInPartiallySortedMatrix(testData, 7);
        Assert.assertFalse(result, testDataIndex + "Didn't find the result");
    }

    @DataProvider(name = "positive")
    public Object[][] positiveData() {
        Integer[][] testData1 = {{1,2,5,8,11}};
        Integer[][] testData2 = {{1,2,5,8,11}, {2,3,6,9,12}, {3,4,7,10,13}};
        return new Object[][] {
            {
                "One row matrix",
                testData1
            },
            {
                "Multiple row Matrix",
                testData2
            }
        };
    }

    @DataProvider(name = "negative")
    public Object[][] negativeData() {
        Integer[][] testData1 = {{}};
        Integer[][] testData2= {{1,2,5,8,11}};
        Integer[][] testData3 = {{10,11,12,13,14}, {12,13,14,15,16}, {13,14,15,16,17}};
        return new Object[][] {
            {
                "Empty matrix",
                testData1
            },
            {
                "Matrix doesn't include mapping",
                testData2
            },
            {
                "Smaller than smallest one",
                testData3
            }
        };
    }
}
