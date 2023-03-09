package basic.design_patterns;

public class FactoryWithDefaultMethodsEx {

    public static void main(String[] args) {
        call(new DogPerson());
        call(new CatLover());

        /*
        Abstract Factory vs Factory Method

        Factory method: A class or an interface relies on a derived
        class to provide the implementation whereas the base provides
        the common behaviour.

        Factory method uses inheritance as a design tool.
        Abstract Factory uses delegation as a tool.

         */
    }

    public static void call(Person person) {
        person.play();
    }
}

interface Person {
    //private Pet pet; // cannot have private fields
    // rather than having fields, have abstract methods
    Pet getPet();

    default void play() {
        System.out.println("Playing with " + getPet());
    }
}

interface Pet {}

class Dog implements Pet {}
class Cat implements Pet {}

class DogPerson implements Person {
    private Dog dog = new Dog();
    public Pet getPet() {
        return dog;
    }
}

class CatLover implements Person {
    private Cat cat = new Cat();

    @Override
    public Pet getPet() {
        return cat;
    }
}
