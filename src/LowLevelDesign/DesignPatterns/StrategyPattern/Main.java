package LowLevelDesign.DesignPatterns.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        // Using BubbleSort strategy
        sorter.setStrategy(new BubbleSort());
        sorter.sortArray();

        // Using QuickSort strategy
        sorter.setStrategy(new QuickSort());
        sorter.sortArray();
    }
}
