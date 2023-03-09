package basic.design_patterns.creational;

import java.util.Scanner;

public class FactoryExample {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        GetPlanFactory pf = new GetPlanFactory();

        System.out.println("Enter the name of plan");
        String planName = kb.nextLine();

        System.out.println("Enter the number of units consumed");
        int units = Integer.parseInt(kb.nextLine());

        Plan p = pf.getPlan(planName);

        System.out.println("Bill for "+planName+ ", units " + units
        + " is ");
        p.getRate();
        p.calculateBill(units);


    }
}

abstract class Plan {
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units) {
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan {
    public void getRate() {
        rate = 3.50;
    }
}

class CommercialPlan extends Plan {
    public void getRate() {
        rate = 7.50;
    }
}

class InstitutionalPlan extends Plan {
    public void getRate() {
        rate = 3.50;
    }
}

class GetPlanFactory {
    public Plan getPlan(String planType) {
        if (planType == null) return null;

        if (planType.equals("Domestic Plan")) {
            return new DomesticPlan();
        } else if (planType.equals("Commercial Plan")) {
            return new CommercialPlan();
        } else if (planType.equals("Institution Plan")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}
