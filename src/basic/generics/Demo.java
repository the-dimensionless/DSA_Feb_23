package basic.generics;

public class Demo {
    public static void main(String[] args) {
        Data<String> d1 = new Data<>("ABC");
        Data<Integer> d2 = new Data<>(10);

        IData<String> d3 = new Data<>("Example generic Interface");
        System.out.println(d3.toString());
    }
}
