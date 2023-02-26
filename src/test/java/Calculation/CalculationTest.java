package Calculation;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculationTest {

    @Test(dataProvider = "dataForAdding", dataProviderClass = GetData.class)
    public void addition (int a, int b, int c){
        Assert.assertEquals(a + b, c, "Adding is incorrect");
//        System.out.println(a + "+" + b + "=" + c);
    }
    @Test(dataProvider = "dataForSubtract", dataProviderClass = GetData.class)
    public void subtract (int a, int b, int c){
        Assert.assertEquals(a - b, c, "Subtract is incorrect");
//        System.out.println(a + "-" + b + "=" + c);
    }
    @Test(dataProvider = "dataForMultiplication", dataProviderClass = GetData.class)
    public void multiplication (int a, int b, int c){
        Assert.assertEquals(a * b, c, "Multiplication is incorrect");
//        System.out.println(a + "*" + b + "=" + c);
    }

    @Test(dataProvider = "dataForDivision", dataProviderClass = GetData.class)
    public void division (int a, int b, int c){
        Assert.assertEquals(a / b, c, "Division is incorrect");
//        System.out.println(a + "/" + b + "=" + c);
    }

    @Parameters(value = "finishing")
    @Test()
    public void paramTest (String param) {
        System.out.println(param);
    }
}


