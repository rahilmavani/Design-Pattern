package Flyweight;

import java.util.HashMap;

interface Vehicle {
    void buy();
}

class Car implements Vehicle {
    private final String color;
    private int price;

    public Car(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void buy() {
        System.out.println("Car of Color: " + color + " and Price: " + price);
    }
}

class VehicleFactory {
    private static final HashMap carMap = new HashMap();
    public static Vehicle getCar(String color) {
        Car car = (Car) carMap.get(color);

        if(car == null) {
            car = new Car(color);
            carMap.put(color, car);
            System.out.println("Buying Car of color: " + color);
        }
        return car;
    }
}

public class FlyWeightDemo {
    private static final String[] colors = {"Black", "White", "Red"};

    public static void main(String[] args) {
        for(int i = 0; i < 8; i++) {
            Car car = (Car) VehicleFactory.getCar(getRandomColor());
            car.setPrice(getRandomPrice());
            car.buy();
        }
    }
    private static int getRandomPrice() {
        return ((int)(Math.random()*10000));
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
}