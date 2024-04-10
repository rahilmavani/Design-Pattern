package Factory;

import java.util.Scanner;

abstract class Fuel{
    protected double price;
    abstract void getPrice();

    public void calculateBill(int liters){
        System.out.println(liters*price);
    }
}

class Petrol extends Fuel{
    public void getPrice(){
        price = 110;
    }
}

class Diesel extends Fuel{
    public void getPrice() {
        price = 95;
    }
}

class Jet extends Fuel{
    public void getPrice() {
        price = 250;
    }
}

class GetFuelFactory{
    public Fuel getFuel(String fuelType){
        if (fuelType == null){
            return null;
        }
        if (fuelType.equalsIgnoreCase("Petrol")){
            return new Petrol();
        }
        else if (fuelType.equalsIgnoreCase("Diesel")) {
            return new Diesel();
        }
        else if (fuelType.equalsIgnoreCase("JetFuel")){
            return new Jet();
        }
        return null;

    }
}

public class GenerateBill{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Type of Fuel: ");
        String fuelType = sc.nextLine();

        System.out.println("Enter Amount of fuel (in liters): ");
        int amount = sc.nextInt();

        GetFuelFactory fuelFactory = new GetFuelFactory();
        Fuel f = fuelFactory.getFuel(fuelType);

        System.out.println("Fuel type: " + fuelType + " | " + "Liters: " + amount);
        f.getPrice();
        f.calculateBill(amount);
    }
}