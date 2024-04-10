package Decorator;

interface Computer{
    void build();
}

class Dell implements Computer{
    @Override
    public void build(){
        System.out.println("Brand: Dell");
    }
}
class HP implements Computer{
    @Override
    public void build() {
        System.out.println("Brand: HP");
    }
}

class ComputerDecorator implements Computer{
    protected Computer decoratedComputer;

    public ComputerDecorator(Computer decoratedComputer) {
        this.decoratedComputer = decoratedComputer;
    }

    public void build(){
        decoratedComputer.build();
        System.out.println("Color: Red");
    }
}
public class Decorator{
    public static void main(String[] args) {
        Dell pc1 = new Dell();
        HP pc2 = new HP();
        ComputerDecorator newpc1 = new ComputerDecorator(new Dell());
        ComputerDecorator newpc2 = new ComputerDecorator(new HP());

        pc1.build();
        System.out.println("Decorated");
        newpc1.build();
        System.out.println("-------------");
        pc2.build();
        System.out.println("Decorated");
        newpc2.build();
    }
}

