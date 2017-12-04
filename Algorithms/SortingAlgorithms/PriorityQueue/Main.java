package com.sia;

public class Main {

  public static void main(String[] args) {

    PriorityQueue queue = new PriorityQueue();
    queue.Insert(11);
    queue.Insert(12);
    queue.Insert(13);
    queue.Insert(14);
    queue.Insert(15);
    queue.Insert(16);
    queue.Insert(17);

    queue.PrintArray();

    queue.ExtractMax();
    queue.PrintArray();
    queue.ExtractMax();
    queue.PrintArray();
      queue.ExtractMax();
      queue.PrintArray();
      queue.ExtractMax();
      queue.PrintArray();

  }
}




