package Cars;

import org.slf4j.LoggerFactory;

public class StrangeColorException extends Exception{
    private final org.slf4j.Logger Log = LoggerFactory.getLogger(Car.class);
    final String color;

    public StrangeColorException(String color) {
        this.color = color;
        Log.error("Car color is {}", color);
    }

}


