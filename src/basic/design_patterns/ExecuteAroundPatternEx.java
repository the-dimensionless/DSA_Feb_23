package basic.design_patterns;

import java.util.function.Consumer;

public class ExecuteAroundPatternEx {
    // remove burden of object allocation & deallocation
    // problem is to clean up
    // no finalize(), no System.gc()
    public static void main(String[] args) {
//        Resource r = new Resource();
//        r.op1();
//        r.op2();
//
//        System.gc(); // Hope
//
//        r.close(); // good but what if there was an exception
        // so not a good solution

        // we could use try {} finally {}
        // code is verbose and easy to forget try{} and finally{}

        //ARM: Automatic Resource Management
        // also called try with resources

//        try (Resource r = new Resource()) {
//            r.op1();
//            r.op2();
//        } // works

        // if we forget try, again it won't work even tho less verbose
//        Resource r = new Resource();
//        r.op1();
//        r.op2();

        Resource.use(resource -> {
            resource.op1();
            resource.op2();
        });


    }
}

class Resource {
    private Resource() {
        System.out.println("created...");
    }

    public Resource op1() {
        System.out.println("op1");
        return this;
    }

    public Resource op2() {
        System.out.println("op2");
        return this;
    }

//    public void finalize() { // BAD IDEA & deprecated
//        System.out.println("release external resources");
//    }

    private void close() {
        System.out.println("close method: release");
    }

    public static void use(Consumer<Resource> block) {
        Resource r = new Resource(); // before

        try {
            block.accept(r);
        } finally {
            r.close(); // after
        }

        // execute around pattern
    }
}
