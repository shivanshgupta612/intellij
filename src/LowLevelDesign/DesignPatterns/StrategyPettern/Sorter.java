package LowLevelDesign.DesignPatterns.StrategyPettern;

public class Sorter {
    SortingStrategy sortingStrategy;
    public void setStrategy(SortingStrategy strategy){
        this.sortingStrategy=strategy;
    }
    public <BubbleSortStrategy> void setStrategy(BubbleSortStrategy bubbleSortStrategy) {
    }

    public void sortArray() {
        sortingStrategy.sort();
    }
}
