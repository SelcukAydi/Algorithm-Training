package com.sia;

public class CountingSort {

    private int[] inputList  = null;
    private int[] tempList   = null;
    private int[] outputList = null;
    private int   maxValue   = 0;

    public CountingSort(int[] inputList, int maxValue) {
        if(maxValue < 0)
            this.maxValue = 0;
        else
            this.maxValue = maxValue;
        this.inputList = inputList;
        outputList = new int[inputList.length + 1];
        tempList = new int[maxValue + 1];
    }

    private int[] preProcessTempList() {
        int[] result = new int[tempList.length];

        for(int i = 0; i < inputList.length; i++)
            result[inputList[i]]++;

        for(int i = 1; i <= maxValue; i++)
            result[i] = result[i] + result[i - 1];
        return result;
    }

    public void sortArray() {
        tempList = preProcessTempList();
        for(int i = inputList.length - 1; i >= 0; i--) {
            outputList[tempList[inputList[i]]] = inputList[i];
            tempList[inputList[i]]--;
        }
    }

    public int findHowManyElementFallsIntoRange(int a, int b) {
        if(a < 0 || a > maxValue || b < 0 || b > maxValue)
            return -1;
        int[] result = preProcessTempList();
        if(a == 0)
            return result[b];
        else
            return result[b] - result[a - 1];
    }

    public void printArray() {
        for(int i = 0; i < outputList.length; i++)
            System.out.print(outputList[i] + "  ");
    }
}
