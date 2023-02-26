package Cars;

import org.testng.annotations.Test;

public class TestCar {

    @Test
    public void testCar1() throws StrangeColorException {
        Car car1 = new Car("mazda");
    }

    @Test
    public void testCar2() throws StrangeColorException {
        Car car2 = new Car("jeep", "green");
       // car2.changeColor("gold");
    }
    @Test
    public void testCar3() throws StrangeColorException {
        Car car3 = new Car("honda", "yellow", 1.6);
    }

    @Test
    public void testCar4() throws StrangeColorException {
        Car car4 = new Car("toyota", "white", 2.0, 180);
        car4.changeColor("blue");
    }
    @Test
    public void testCar5() throws StrangeColorException {
        Car car4 = new Car("bmw", "black");
        car4.changeColor("orange");
    }
}

