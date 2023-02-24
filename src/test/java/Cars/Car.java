package Cars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car {
    private String brand;
    private String color;
    private double engineVolume;
    private double maxSpeed;
    static int carAmount;
    private static Car[] storeCars = new Car[10];

    private final Logger Log = LoggerFactory.getLogger(Car.class);

    public Car(String brand) {
        this.brand = brand;
        carAmount++;
        Log.info("Car brand is {}", brand);
    }
    public Car(String brand, String color) throws StrangeColorException {
        this.brand = brand;
        this.color = color;
        if (color.equals("gold")) throw new StrangeColorException(color);
        Log.info("Car brand is {}, color is {}", brand, color);

    }
    public Car(String brand, String color, double engineVolume) throws StrangeColorException {
        this.brand = brand;
        this.color = color;
        this.engineVolume = engineVolume;
        if (color.equals("gold")) throw new StrangeColorException(color);
        Log.info("Car brand is {}, color is {}, engine volume is {}", brand, color, engineVolume);
    }
    public Car(String brand, String color, double engineVolume, double maxSpeed) throws StrangeColorException {
        this.brand = brand;
        this.color = color;
        this.engineVolume = engineVolume;
        this.maxSpeed = maxSpeed;
        if (color.equals("gold")) throw new StrangeColorException(color);
        Log.info("Car brand is {}, color is {}, engine volume is {}, max speed is {}",
                brand, color, engineVolume, maxSpeed);
    }
    public void changeColor (String color) throws StrangeColorException {
        this.color = color;
        if (color.equals("gold")) throw new StrangeColorException(color);
        Log.info("Car color was changed to {}", color);
    }

    public void printCars (Car...cars){
        for(Car car : cars) System.out.println(car); //same as: for (int n = 1; n<= cars.length; n++){
        // System.out.println(cars[n-1]);*/
    }

    @Override
    public String toString() {
        return "Cars.Car.Cars.Car {" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", engineVolume=" + engineVolume +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

}

