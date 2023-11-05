/*
 * STACK
 * Follows LIFO - Last In First Out
 * Elements INSERTED last is DELETED first
 * 
 * FUNCTIONS:
 *  - push: To insert element into the stack (Insert at top of the stack)
 *  - pop: To delete element from the stack (Delete from top of the stack)
 *  - isFull: To check whether stack is full or not
 *  - isEmpty: To check whether stack is empty or not
 *  - peek: To get the value of topmost element from the stack without performing any operations on it
 *  - siza: To get the total number of elements in stack
 */

import java.util.ArrayList;

public class Stacks<T> {
    ArrayList<T> stack;
    int maxSize;

    Stacks() {
        this.stack = new ArrayList<>();
        this.maxSize = -1;
    }

    Stacks(int initialSize) {
        this.stack = new ArrayList<>(initialSize);
        this.maxSize = -1;
    }

    Stacks(int initialSize, int maxSize) throws Exception {
        this(initialSize);
        if(maxSize == 0) {
            throw new Exception("Max size cannot be 0");
        } else {
            this.maxSize = maxSize;
        }
    }

    public void push(T elem) throws StackOverflow {
        if(this.maxSize > 0 && this.stack.size() >= this.maxSize) {
            throw new StackOverflow("Cannot push element, stack already full");
        }

        this.stack.add(elem);
    }

    public T pop() throws StackUnderflow {
        if(this.stack.size() == 0) {
            throw new StackUnderflow("Cannot delete from empty stack");
        }

        return this.stack.remove(this.stack.size() - 1);
    }

    public T peek() {
        if(this.stack.size() == 0) {
            return null;
        }
        return this.stack.get(this.stack.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(T val: this.stack) {
            builder.append(val);
            builder.append(", ");
        }
        
        if(builder.charAt(builder.length() - 1) == '[') {
            return new String("[]");
        }

        builder.append("\b\b]");
        return builder.toString();
    }
}