package basic.design_patterns.creational;

public class AbstractFactoryExample {
    public static void main(String[] args) {

    }
}

interface Bank {
    String getBankName();
}

class HDFC implements Bank {
    private final String BNAME;

    public HDFC() {
        BNAME = "HDFC Bank";
    }

    public String getBankName() {
        return BNAME;
    }
}

class ICICI implements Bank {
    private final String BNAME;

    public ICICI() {
        BNAME = "ICICI Bank";
    }

    public String getBankName() {
        return BNAME;
    }
}

class SBI implements Bank {
    private final String BNAME;

    public SBI() {
        BNAME = "SBI Bank";
    }

    public String getBankName() {
        return BNAME;
    }
}

abstract class Loan {
    protected double rate;
    abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanAmount,
                                     int years) {
        double EMI;
        int n;

        n = years * 12;
        rate = rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanAmount);
    }
}

class HomeLoan extends Loan {
    public void getInterestRate(double r) {
        rate = r;
    }
}

class BusinessLoan extends Loan {
    public void getInterestRate(double r) {
        rate = r;
    }
}

class EducationLoan extends Loan {
    public void getInterestRate(double r) {
        rate = r;
    }
}

abstract class AbstractFactory {
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}

class BankFactory extends AbstractFactory {
    public Bank getBank(String bank){
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("HDFC")){
            return new HDFC();
        } else if(bank.equalsIgnoreCase("ICICI")){
            return new ICICI();
        } else if(bank.equalsIgnoreCase("SBI")){
            return new SBI();
        }
        return null;
    }
    public Loan getLoan(String loan) {
        return null;
    }
}

class LoanFactory extends AbstractFactory{
    public Bank getBank(String bank){
        return null;
    }

    public Loan getLoan(String loan){
        if(loan == null){
            return null;
        }
        if(loan.equalsIgnoreCase("Home")){
            return new HomeLoan();
        } else if(loan.equalsIgnoreCase("Business")){
            return new BusinessLoan();
        } else if(loan.equalsIgnoreCase("Education")){
            return new EducationLoan();
        }
        return null;
    }
}

class FactoryCreator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}
