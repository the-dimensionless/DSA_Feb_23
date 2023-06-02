package interview_quest;

public class test implements B {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    @Override
    public void doSomething() {
        System.out.println("Do Something");
    }

    @Override
    public void wow() {
        System.out.println("Wow");
    }
}

@FunctionalInterface
interface A {
    public void doSomething();
}

interface B extends A {
    public void wow();
}
