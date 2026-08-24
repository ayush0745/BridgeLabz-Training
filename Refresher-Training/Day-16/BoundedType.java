import java.util.List;

class NumericBox<T extends Number> {
    private T value;

    public NumericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Main {

    static double sumOfList(List<? extends Number> list) {
        double sum = 0;

        for (Number n : list) {
            sum += n.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {

        NumericBox<Integer> box1 = new NumericBox<>(100);
        NumericBox<Double> box2 = new NumericBox<>(25.5);

        List<Integer> intList = List.of(10, 20, 30);
        List<Double> doubleList = List.of(10.5, 20.5, 30.5);

        System.out.println(sumOfList(intList));
        System.out.println(sumOfList(doubleList));
    }
}