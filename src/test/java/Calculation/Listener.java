package Calculation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Start of the testing");
    }

    @Override
    public void onTestStart(ITestResult method) {
        System.out.println("Starting test: " + method.getName());
    }
    @Override
    public  void onTestSuccess(ITestResult method) {
        System.out.println("Testing of " + method.getName() + " is finished");
    }

    @Override
    public void onFinish(ITestContext method) {
        System.out.println("End of the testing");
    }

//     @BeforeClass
//     void Start(){
//        System.out.println("Start of the testing");
//    }
//     @BeforeMethod
//     void before(Method method) {
//        System.out.println("Starting test: " + method.getName());
//    }
}
