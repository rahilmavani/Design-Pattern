package Memento;

import java.util.ArrayList;
import java.util.List;

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento) {
        state = Memento.getState();
    }
}

class CareTaker {
    private List<Memento> MementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        MementoList.add(state);
    }

    public Memento get(int index) {
        return MementoList.get(index);
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker caretaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: "+ originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved state: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved state: " + originator.getState());


    }
}