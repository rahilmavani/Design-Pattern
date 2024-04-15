package Composite;

import java.util.LinkedList;
import java.util.List;

interface Component {
    void showPrice();
    int getPrice();
}

class Item implements Component {
    int price;
    String Name;

    public Item(String Name, int price) {
        this.price = price;
        this.Name = Name;
    }

    @Override
    public void showPrice() {
        System.out.println("Item: " + Name + " Price: " + price);

    }

    @Override
    public int getPrice() {
        return price;
    }

}

class Composite implements Component {
    String name;
    List<Component> l = new LinkedList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void showPrice() {
        for (Component c : l) {
            c.showPrice();
        }
    }

    public void addItem(Component i) {
        l.add(i);
    }

    @Override
    public int getPrice() {
        int p = 0;

        for (Component c : l) {
            p += c.getPrice();
        }
        return p;
    }
}

public class Demo {
    public static void main(String[] args) {

        Composite laptop = new Composite("laptop");

        Item keyboard = new Item("keyboard", 5000);
        Item speaker = new Item("speaker", 4200);
        Item screen = new Item("screen", 20000);

        Item microsoft = new Item("microsoft", 2800);
        Item adobe = new Item("adobe", 4500);
        Item openai = new Item("openai", 4800);

        Composite hardware = new Composite("hardware");
        Composite software = new Composite("software");
        hardware.addItem(screen);
        hardware.addItem(speaker);
        hardware.addItem(keyboard);

        software.addItem(microsoft);
        software.addItem(adobe);
        software.addItem(openai);

        laptop.addItem(hardware);
        laptop.addItem(software);
        laptop.showPrice();
        System.out.println(laptop.getPrice());
    }
}
