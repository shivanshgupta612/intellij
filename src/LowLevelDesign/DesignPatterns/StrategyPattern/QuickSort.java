package LowLevelDesign.DesignPatterns.StrategyPattern;

public class QuickSort implements SortingStrategy{

    @Override
    public void sort() {
        System.out.println("Sorting using QuickSort Strategy");
    }
}
