/*
 * Properties:
 *  1. Represented as complete binary tree i.e., Every level is full except for leaf and leaf starts from left to right (insertions)
 *  2. Stored like an array but represented as tree
 *  3. Every node value:
 *      a. Max Heap: Greater than or equal to all of its children
 *      b. Min Heap: Less than or equal to all of its children
 *  4. Max/Min item at top depending on Max/Min Heap
 *  5. Accessing Elements (0-indexed):
 *      Accessing Child: If i -> Parent:
 *          Left Child: 2*i + 1
 *          Right Child: 2*i + 2
 *      Accessing Parent: If i-> Child:
 *          Parent: (i - 1) / 2
 *  6. Height = log(n)
 */

import java.util.ArrayList;

public class Heaps extends Heap {
    // Default to Min-Heap
    Heap h;

    public Heaps() {
        this.h = new MinHeap();
    }

    public Heaps(String type) throws Exception {
        if (type.toLowerCase().equals("min")) {
            this.h = new MinHeap();
        } else if (type.toLowerCase().equals("max")) {
            this.h = new MaxHeap();
        } else {
            throw new Exception("Invalid Heap Type, it can be either 'min' or 'max'");
        }
    }

    public void insert(int data) throws Exception {
        this.h.insert(data);
    }

    public int delete() throws Exception {
        return this.h.delete();
    }

    public void heapify(int[] array) {
        this.h.heapify(array);
    }

    public int get() throws Exception {
        return this.h.get();
    }

    @Override
    public String toString() {
        return this.h.toString();
    }
}

abstract class Heap {
    ArrayList<Integer> heap;
    final int maxSize;

    public Heap() {
        heap = new ArrayList<>();
        this.maxSize = -1;
    }

    public Heap(int maxSize) {
        heap = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    /*
     * While inserting, insert the new value at the end of array (at leaf node),
     * (For Min-Heap)
     * then check whether the current element is less than the parent, if it is
     * less, then swap both the values.
     * Repeat this process till the value of child not greater than parent.
     * (For Max-Heap)
     * check whether the current element is greater than parent, it it is
     * greater, than swap both the values.
     * Repeat this process till the value of child not less than parent..
     */
    public abstract void insert(int data) throws Exception;

    /*
     * Remove the first element and put the value of last element at first place
     * (Min-Heap)
     *      Then check whether the value of this element is less than left & right child
     *      If it is greater, than swap the current value with smaller value and
     *      iteratively repeat this process
     * (Max-heap)
     *      Then check whether the value of this element is greater than left and right child
     *      If it is lesser, than swap the current value with greater value and
     *      iteratively repeat this process
     */
    public abstract int delete() throws Exception;

    public abstract void heapify(int[] arr);

    public abstract int get() throws Exception;

    protected int getLeftChild(int parent) {
        return (2 * parent) + 1;
    }

    protected int getRightChild(int parent) {
        return (2 * parent) + 2;
    }

    protected int getParent(int child) {
        return (int) (child - 1) / 2;
    }

    protected void swap(int child, int parent) {
        int child_val = this.heap.get(child);
        this.heap.set(child, this.heap.get(parent));
        this.heap.set(parent, child_val);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i : this.heap) {
            builder.append(i + ", ");
        }
        builder.append("]");
        return builder.toString();
    }
}

class MinHeap extends Heap {
    public MinHeap() {
        super();
    }

    public MinHeap(int maxSize) {
        super(maxSize);
    }

    public void insert(int data) throws Exception {
        if (this.maxSize > 0 && this.heap.size() >= this.maxSize) {
            throw new Exception(
                    "Insert Error: Heap already full, cannot insert more elements, max heap size: " + this.maxSize);
        }
        this.heap.add(data);
        upheap(this.heap.size() - 1);
    }

    private void upheap(int index) {
        if (index <= 0) {
            return;
        }
        int parent = this.getParent(index);
        if (this.heap.get(index) < this.heap.get(parent)) {
            swap(index, parent);
            upheap(parent);
        }
    }

    public int get() throws Exception {
        if (this.heap.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.heap.get(0);
    }

    public int delete() throws Exception {
        if (this.heap.size() == 0) {
            throw new Exception("Underflow: Cannot delete from empty heap");
        }

        int deleted = this.heap.get(0);
        int last = this.heap.remove(this.heap.size() - 1);

        if (!this.heap.isEmpty()) {
            this.heap.set(0, last);
            downheap(0);
        }

        return deleted;
    }

    private void downheap(int index) {
        int leftChild = this.getLeftChild(index);
        int rightChild = this.getRightChild(index);

        int min = index;
        if (leftChild < this.heap.size() && this.heap.get(min) > this.heap.get(leftChild)) {
            min = leftChild;
        }

        if (rightChild < this.heap.size() && this.heap.get(min) > this.heap.get(rightChild)) {
            min = rightChild;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public void heapify(int[] arr) {

    }
}

class MaxHeap extends Heap {
    public MaxHeap() {
        super();
    }

    public MaxHeap(int maxSize) {
        super(maxSize);
    }

    public void insert(int data) throws Exception {
        if (this.maxSize > 0 && this.heap.size() >= this.maxSize) {
            throw new Exception(
                    "Insert Error: Heap already full, cannot insert more elements, max heap size: " + this.maxSize);
        }
        this.heap.add(data);
        upheap(this.heap.size() - 1);
    }

    private void upheap(int index) {
        if (index <= 0) {
            return;
        }
        int parent = this.getParent(index);
        if (this.heap.get(index) > this.heap.get(parent)) {
            swap(index, parent);
            upheap(parent);
        }
    }

    public int get() throws Exception {
        if (this.heap.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.heap.get(0);
    }

    public int delete() throws Exception {
        if (this.heap.size() == 0) {
            throw new Exception("Underflow: Cannot delete from empty heap");
        }

        int deleted = this.heap.get(0);
        int last = this.heap.remove(this.heap.size() - 1);

        if (!this.heap.isEmpty()) {
            this.heap.set(0, last);
            downheap(0);
        }

        return deleted;
    }

    private void downheap(int index) {
        int leftChild = this.getLeftChild(index);
        int rightChild = this.getRightChild(index);

        int min = index;
        if (leftChild < this.heap.size() && this.heap.get(min) < this.heap.get(leftChild)) {
            min = leftChild;
        }

        if (rightChild < this.heap.size() && this.heap.get(min) < this.heap.get(rightChild)) {
            min = rightChild;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public void heapify(int[] arr) {

    }
}