import java.util.ArrayList;

public class PriorityQueue {

    private ArrayList<Integer> queue;
    private int HeapSize;

    public PriorityQueue() {
        queue = new ArrayList<Integer>();
        HeapSize = 0;
    }

    public int getMaxValue() {
        return queue.get(0);
    }

    private void MaxHeapFIY(int parent) {
        int leftChild   = getLeftChild(parent);
        int rightChild  = getRightChild(parent);
        int largestNode = queue.get(parent);

        if(leftChild <= HeapSize && queue.get(leftChild) > queue.get(parent)) {
            largestNode = leftChild;
        }

        else if(rightChild <= HeapSize && queue.get(rightChild) > queue.get(largestNode)) {
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

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return getLeftChild(index) + 1;
    }
}
