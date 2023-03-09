package basic.design_patterns.creational;

public class SingletonEx {
    public static void main(String[] args) {
    // readResolve, serializing a singleton
    }
}

class EarlyInstantiation {
    private static EarlyInstantiation ob = new EarlyInstantiation();

    private EarlyInstantiation() {

    }

    public static EarlyInstantiation getEarlyInstantiation() {
        return ob;
    }
}

class LazyInstantiation {
    private static LazyInstantiation ob;

    private LazyInstantiation() {}

    public static LazyInstantiation getLazyInstantiation() {
        if (ob == null) {
            synchronized (LazyInstantiation.class) {
                if (ob == null) {
                    ob = new LazyInstantiation();
                }
            }
        }
        return ob;
    }
}
