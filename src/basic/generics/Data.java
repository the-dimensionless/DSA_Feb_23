package basic.generics;

public class Data<T> implements IData<T> {
    private T data;

    public Data(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T t) {
        this.data = t;
    }

    @Override
    public String toString() {
        return "Data: " + data;
    }
}
