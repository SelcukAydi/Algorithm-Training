package com.sia;

public class Main {

    public static void main(String[] args) {

        int size = 12;
        int[] arr = { 2,8,7,1,3,5,6,4,6,8,7,9 };

        QuickSort quickSort = new QuickSort(size, arr);
        quickSort.sort(0, size - 1);
        quickSort.print();

        }
}
