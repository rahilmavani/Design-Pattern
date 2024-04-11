package AbstractFactory;
interface Shape{
    void draw();
}

class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class RoundedRectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing rounded rectangle");
    }
}

abstract class AbstractFactory{
    abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory{
    public Shape getShape(String shapeType){
        if (shapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
        else if (shapeType.equalsIgnoreCase("Cricle")){
            return new Circle();
        }

        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory{
    public Shape getShape(String shapeType){
        if (shapeType.equalsIgnoreCase("RoundedRectangle")){
            return new RoundedRectangle();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded){
        if (rounded){
            return new RoundedShapeFactory();
        }
        else{
            return new ShapeFactory();
        }
    }
}

public class AbstractFactoryExample{
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        Shape shape1 = shapeFactory.getShape("Rectangle");
        shape1.draw();
        AbstractFactory round = FactoryProducer.getFactory(true);
        Shape shape2 = round.getShape("RoundedRectangle");
        shape2.draw();

    }
}
