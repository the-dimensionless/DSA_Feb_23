package basic.explain;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class SharedMutabilityEx {
    static int y = 10;

    public static int operate(int x) {
        System.out.println("Hi");
        return x*y;
    }

    public static void main(String[] args) throws Exception {


    }
}

class A implements Runnable {
    String fileName="ABC";


    @Override
    public void run() {
       // fileName
    }
}

class B implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}
