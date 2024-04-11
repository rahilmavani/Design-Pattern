package Builder;

class Phone {
    private final String os;
    private final int ram;
    private final String processor;
    private final double screenSize;
    private final int battery;


    public Phone(String os, int ram, String processor, double screenSize, int battery) {
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }
}

class PhoneBuilder {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone() {
        return new Phone(os, ram, processor, screenSize, battery);
    }
}

public class Shop {
    public static void main(String[] args) {
        Phone p = new PhoneBuilder()
                .setOs("Android")
                .setRam(4)
                .setProcessor("Snapdragon")
                .setScreenSize(6.0)
                .setBattery(4000)
                .getPhone();
        System.out.println(p);
    }
}
