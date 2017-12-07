package com.sia;

public class Main {

    public static void main(String[] args) {

        int[] arr = { 2,5,3,0,2,3,0,3 };

        CountingSort countingSort = new CountingSort(arr, 5);
        countingSort.sortArray();
        countingSort.printArray();
        System.out.println("\n" + countingSort.findHowManyElementFallsIntoRange(0,0) +
                                                        "  elements falls into the range.");



    }
}
