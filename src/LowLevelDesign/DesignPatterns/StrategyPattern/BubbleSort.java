package LowLevelDesign.DesignPatterns.StrategyPattern;

public class BubbleSort implements SortingStrategy{

    @Override
    public void sort() {
        System.out.println("Sorting using BubbleSort Strategy");
    }
}
