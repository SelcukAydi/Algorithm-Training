package com.sia;

public class QuickSort {

    private int[] list = null;
    private int listSize;

    public QuickSort(int listSize, int[] list) {
        this.listSize = listSize;
        this.list = list;
    }

    private int partition(int low, int high) {
        int i, j, pivot;
        i = low - 1;
        pivot = list[high];
        for (j = low; j < high; ++j) {
            if (list[j] <= pivot) {
                ++i;
                exchangeElements(i, j);
            }
        }
        exchangeElements(i + 1, high);
        return ++i;
    }

    public void sort(int low, int high) {
        if(low < high) {
            int q = partition(low, high);
            sort(low, q - 1);
            sort(q + 1, high);
        }
    }

    private void exchangeElements(int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

   public void print() {
        System.out.println("");
        for(int i = 0; i < listSize; ++i)
            System.out.print(list[i] + " ");
       System.out.println("");
   }
}