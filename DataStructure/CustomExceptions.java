package DataStructure;
public class CustomExceptions {}


// Exception when performing delete operation on array with 0 elements
class ArrayUnderflow extends Exception {
    public ArrayUnderflow() {
        super("Underflow: Cannot delete from empty array");
    }

    public ArrayUnderflow(String message) {
        super(message);
    }
}

// Performing pop operation on empty stack
class StackUnderflow extends Exception {
    public StackUnderflow() {
        super("Stack Underflow: Cannot pop from an empty stack");
    }

    public StackUnderflow(String message) {
        super(message);
    }
}

// Performing push operation on full stack
class StackOverflow extends Exception {
    public StackOverflow() {
        super("Stack Overflow: Cannow push element, stack already full");
    }

    public StackOverflow(String message) {
        super(message);
    }
}

// Performing push operation on full queue
class QueueOverflow extends Exception {
    public QueueOverflow() {
        super("Stack Overflow: Cannow push element, queue already full");
    }

    public QueueOverflow(String message) {
        super(message);
    }
}

// Performing pop operation on empty stack
class QueueUnderflow extends Exception {
    public QueueUnderflow() {
        super("Stack Underflow: Cannot pop from an empty queue");
    }

    public QueueUnderflow(String message) {
        super(message);
    }
}