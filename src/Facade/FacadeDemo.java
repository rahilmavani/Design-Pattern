package Facade;

interface Mobile {
    void buy();
}

class Samsung implements Mobile {
    @Override
    public void buy() {
        System.out.println("Brand: Samsung");
    }
}

class Apple implements Mobile {
    @Override
    public void buy() {
        System.out.println("Brand: Apple");
    }
}

class Nothing implements Mobile {
    @Override
    public void buy() {
        System.out.println("Brand: Nothing");
    }
}

class PhoneMaker {
    private Mobile samsung;
    private Mobile apple;
    private Mobile nothing;

    public PhoneMaker() {
        samsung = new Samsung();
        apple = new Apple();
        nothing = new Nothing();
    }

    public void buySamsung() {
        samsung.buy();
    }
    public void buyApple() {
        apple.buy();
    }
    public void buyNothing() {
        nothing.buy();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        PhoneMaker phone = new PhoneMaker();
        phone.buySamsung();
        phone.buyApple();
        phone.buyNothing();
    }
}