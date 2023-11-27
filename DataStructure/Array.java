package DataStructure;
/**
 * Implementation of custom dynamic array
 * Increases size as necessary
 */
public class Array<T> {
    private int SIZE = 10; // Default Size = 19
    // private Object obj[]; // Object array to store array elements
    private T[] obj;
    private int top = 0;

    public Array() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public Array(int size) {
        this.SIZE = size;
        // obj = new Object[this.SIZE];
        obj = (T[]) new Object[this.SIZE];
    }

    public Array(T[] arr) {
        this(arr.length + 1);
        this.copyArray(arr);
    }

    public Array(int size, T[] arr) {
        this(size > arr.length ? size : arr.length + 1);
        this.copyArray(arr);
    }

    /**
     * Doubles the size of array every time
     * Copies the elements from previous array into new array
     */
    @SuppressWarnings("unchecked")
    private void reallocateSize() {
        this.SIZE *= 2; // Doubles the array size

        Object[] temp = obj; // Stores the previous array value in temporary array

        try {
            obj = (T[]) new Object[this.SIZE]; // Reallocate array to new size
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("Cannot add more element");
        }
        this.top = 0;

        // Copy elements from previous array into this new increased size array
        for (Object val : temp) {
            this.append((T) val);
        }
    }

    // Copy all the elements from an array
    @SuppressWarnings("unchecked")
    private void copyArray(T[] arr) {
        for (Object val : arr) {
            this.append((T) val);
        }
    }

    /**
     * Append new elements at the end of the array
     * If the array length == total size (Overflow condition), reallocate size
     */
    public void append(T val) {
        if (this.top >= this.SIZE) {
            this.reallocateSize();
        }
        obj[this.top++] = val;
    }

    public void insert(T val, int index) {
        if (index > top || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        T prev_val = val;
        T curr_val = (T) obj[index];

        int elem = this.top + 1;
        if (elem >= this.SIZE) {
            this.reallocateSize();
        }
        while (index < elem) {
            obj[index++] = prev_val;
            prev_val = curr_val;
            if (index < elem)
                curr_val = (T) obj[index];
        }
        top = elem;
    }

    public void append(T[] arr) {
        this.copyArray(arr);
    }

    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if(index > this.top) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.obj[index];
    }

    public int length() {
        return this.SIZE;
    }

    // Removes last element from the array
    public T pop() throws ArrayUnderflow {
        if (this.top == 0) {
            throw new ArrayUnderflow();
        }
        return (T) this.obj[this.top--];
    }
    
    // Deletes element at certain index from array
    public T delete(int index) {
        if (index > top || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T deleted = (T) obj[index];

        while(index < top - 1) {
            obj[index++] = obj[index];
        }
        this.top--;

        return deleted;
    }

    // Deletes all the elements from the array
    public void deleteAll() {
        this.top = 0;
    }

    @Override
    public String toString() {
        if (this.top == 0)
            return "{}";
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < this.top; i++) {
            builder.append(obj[i]);
            builder.append(", ");
        }
        builder.append("\b\b}");
        return builder.toString();
    }
}