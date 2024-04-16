package Momento;

import java.util.ArrayList;
import java.util.List;

class Momento {
    private String state;

    public Momento(String state) {
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

    public Momento saveStateToMomento() {
        return new Momento(state);
    }

    public void getStateFromMomento(Momento momento) {
        state = momento.getState();
    }
}

class CareTaker {
    private List<Momento> momentoList = new ArrayList<Momento>();

    public void add(Momento state) {
        momentoList.add(state);
    }

    public Momento get(int index) {
        return momentoList.get(index);
    }
}

public class MomentoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker caretaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMomento());

        originator.setState("State #3");
        caretaker.add(originator.saveStateToMomento());

        originator.setState("State #4");
        System.out.println("Current State: "+ originator.getState());

        originator.getStateFromMomento(caretaker.get(0));
        System.out.println("First saved state: " + originator.getState());
        originator.getStateFromMomento(caretaker.get(1));
        System.out.println("Second saved state: " + originator.getState());


    }
}