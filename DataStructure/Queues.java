package DataStructure;
import java.util.ArrayList;

public class Queues<T> {
    ArrayList<T> queue;
    int maxSize = -1;

    public Queues() {
        queue = new ArrayList<>();
    }
    public Queues(int initialSize) {
        queue = new ArrayList<>(initialSize);
    }
    public Queues(int initialSize, int maxSize) throws Exception {
        this(initialSize);
        if(maxSize == 0) {
            throw new Exception("Max size cannot be 0");
        } else {
            this.maxSize = maxSize;
        }
    }

    public void enqueue(T elem) throws QueueOverflow {
        if(maxSize > 0 && this.queue.size() >= maxSize) {
            throw new QueueOverflow("Cannot insert element " + elem + ", queue already full");
        }
        this.queue.add(elem);
    }

    public T dequeue() throws QueueUnderflow {
        if(this.queue.size() == 0) {
            throw new QueueUnderflow("Cannot delete from an empty queue");
        }
        return this.queue.remove(0);
    }

    public T peek() {
        if(this.queue.size() == 0) {
            return null;
        }
        return this.queue.get(this.queue.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(T val: this.queue) {
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
