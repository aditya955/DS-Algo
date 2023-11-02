/**
 * Implementation of custom dynamic array
 * Increases size as necessary
 */
public class Array<T> {
    private int SIZE = 10;  // Default Size = 19
    private Object obj[];   // Object array to store array elements
    private int top = 0;

    public Array() {
        this(10);   
    }
    
    public Array(int size) {
        this.SIZE = size;
        obj = new Object[this.SIZE];
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
        System.out.println("Reallocating Size:\tCurrent Size: " + this.SIZE + "\tNew Size: " + this.SIZE * 2);
        this.SIZE *= 2; // Doubles the array size

        Object[] temp = obj;    // Stores the previous array value in temporary array

        try {
            obj = new Object[this.SIZE];    // Reallocate array to new size
        } catch(OutOfMemoryError e) {
            throw new OutOfMemoryError("Cannot add more element");
        }
        this.top = 0;

        // Copy elements from previous array into this new increased size array
        for(Object val: temp) {
            this.append((T)val);
        }
    }

    // Copy all the elements from an array
    @SuppressWarnings("unchecked")
    private void copyArray(T[] arr) {
        for(Object val: arr) {
            this.append((T)val);
        }
    }

    /**
     * Append new elements at the end of the array
     * If the array length == total size (Overflow condition), reallocate size
     */
    public void append(T val) {
        if(this.top >= this.SIZE) {
            this.reallocateSize();
        }
        obj[this.top++] = val;
    }

    public void append(T[] arr) {
        this.copyArray(arr);
    }

    @SuppressWarnings("unchecked")
    public T pop() throws ArrayUnderflow {
        if(this.top == 0) {
            throw new ArrayUnderflow();
        }
        return (T)this.obj[this.top--];
    }

    @Override
    public String toString() {
        if(this.top == 0) return "{}";
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(int i = 0; i < this.top; i++) {
            builder.append(obj[i]);
            builder.append(", ");
        }
        builder.append("\b\b}");
        return builder.toString();
    }
}

// Custom Exceptions

// Exception when performing delete operation on array with 0 elements
class ArrayUnderflow extends Exception {
    public ArrayUnderflow() {
        super("Underflow: Cannot delete from empty array");
    }
    public ArrayUnderflow(String message) {
        super(message);
    }
}
