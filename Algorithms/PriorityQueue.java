package com.sia;

import java.util.ArrayList;

public class PriorityQueue {

    private ArrayList<Integer> queue;
    private int HeapSize;

    public PriorityQueue() {
        queue = new ArrayList<Integer>();
        HeapSize = 0;
    }

    public void Insert(int element) {
        queue.add(element);
        HeapSize++;
        int hasAdded = queue.size() - 1;
        int parent = getParent(hasAdded);

        while(queue.get(parent) < queue.get(hasAdded)) {
            ExchangeNodes(parent, hasAdded);
            hasAdded = parent;
            parent = getParent(hasAdded);
        }
    }

    public int ExtractMax() {
        int result = getMax();
        queue.set(0, queue.get(HeapSize - 1));
        HeapSize--;
        MaxHeapFIY(0);
        return result;
    }

    public int getMax() {
        return queue.get(0);
    }

    public int getMaxValue() {
        return queue.get(0);
    }

    private void MaxHeapFIY(int parent) {
        int leftChild   = getLeftChild(parent);
        int rightChild  = getRightChild(parent);
        int largestNode = parent;

        if(leftChild < HeapSize && queue.get(leftChild) > queue.get(parent)) {
            largestNode = leftChild;
        }

        if(rightChild < HeapSize && queue.get(rightChild) > queue.get(largestNode)) {
            largestNode = rightChild;
        }

        if(largestNode != parent) {
            ExchangeNodes(parent, largestNode);
            MaxHeapFIY(largestNode);
        }
    }

    private void ExchangeNodes(int parent, int largestNode) {
        int tmp = queue.get(parent);
        queue.set(parent, queue.get(largestNode));
        queue.set(largestNode, tmp);
    }

    public void PrintArray() {
        int i = 0;
        for(i = 0; i < HeapSize - 1; i++) {
            System.out.print(queue.get(i) + "  ");
        }
        System.out.println(queue.get(i));
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return getLeftChild(index) + 1;
    }

    private int getParent(int child) {
        return (child - 1) / 2;
    }
}