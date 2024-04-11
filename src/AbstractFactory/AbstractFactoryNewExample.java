package AbstractFactory;

interface Bank {
    public void bankName();
}

class HDFC implements Bank {
    @Override
    public void bankName() {
        System.out.println("Visiting HDFC Bank");
    }
}

class ICICI implements Bank {
    @Override
    public void bankName() {
        System.out.println("Visiting ICICI Bank");
    }
}

class SBI implements Bank {
    @Override
    public void bankName() {
        System.out.println("Visiting SBI Bank");
    }
}

class BOB implements Bank {
    @Override
    public void bankName() {
        System.out.println("Visiting Bank of Baroda");
    }
}

abstract class AbstractFactoryAgain {
    abstract Bank getBankName(String bankType);
}

class PrivateBankFactory extends AbstractFactoryAgain {
    public Bank getBankName(String bankType) {
        if (bankType.equalsIgnoreCase("HDFC")) {
            return new HDFC();
        } else if (bankType.equalsIgnoreCase("ICICI")) {
            return new ICICI();
        }
        return null;
    }
}

class GovernBankFactory extends AbstractFactoryAgain {
    public Bank getBankName(String bankType) {
        if (bankType.equalsIgnoreCase("SBI")) {
            return new SBI();
        } else if (bankType.equalsIgnoreCase("BOB")) {
            return new BOB();
        }
        return null;
    }
}

class FactoryProducerAgain {
    public static AbstractFactoryAgain getFactory(boolean type) {
        if (type) {
            return new PrivateBankFactory();
        } else {
            return new GovernBankFactory();
        }
    }
}

public class AbstractFactoryNewExample {
    public static void main(String[] args) {
        AbstractFactoryAgain privateBankFactory = FactoryProducerAgain.getFactory(true);
        Bank bank1 = privateBankFactory.getBankName("HDFC");
        bank1.bankName();
    }
}
