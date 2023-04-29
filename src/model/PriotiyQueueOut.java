package model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriotiyQueueOut<T extends ComparatorPas<T>> {

    private ArrayList<T> heap;

    public PriotiyQueueOut() {
        heap = new ArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        int i = heap.size() - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && heap.get(i).compare(heap.get(parent)) < 0) {
            swap(i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }
    public T delete() {
        if (heap.size() == 0) {
            throw new NoSuchElementException();
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        T root = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));

        int i = 0;
        int leftChild = 1;
        int rightChild = 2;

        while (leftChild < heap.size()) {
            int maxChild = leftChild;
            if (rightChild < heap.size() && heap.get(rightChild).compare(heap.get(leftChild)) < 0) {
                maxChild = rightChild;
            }

            if (heap.get(i).compare(heap.get(maxChild)) < 0) {
                swap(i, maxChild);
                i = maxChild;
                leftChild = 2 * i + 1;
                rightChild = 2 * i + 2;
            } else {
                break;
            }
        }

        return root;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

  public void print() {
    for (T item : heap) {
        System.out.println(item + " ");
    }
    System.out.println();
}

public String printMSg() {
    String msg = "";
    for (T data : heap) {
        msg += data;
    }
    return msg;
}
}