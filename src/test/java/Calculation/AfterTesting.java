package Calculation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.lang.reflect.Method;

public interface AfterTesting {
    @AfterClass
     default void Finish(){
        System.out.println("End of the testing");
    }

    @AfterMethod
     default void after(Method method){
        System.out.println("Testing of " + method.getName() + " is finished");
    }
}
