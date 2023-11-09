public class LinkedList<T> {
    class Node<U> {
        U data;
        Node<U> next;

        Node(U data) {
            this.data = data;
            this.next = null;
        }

        Node(U data, Node<U> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    LinkedList() {
    }

    LinkedList(T data) {
        this.head = new Node<T>(data);
    }

    public void insertFirst(T val) {
        if (this.head == null) {
            this.head = new Node<>(val);
            this.head.data = val;
            this.tail = head;
            this.size++;
            return;
        }
        Node<T> temp = new Node<T>(val, this.head);
        this.head = temp;
        this.size++;
    }

    public void insert(T val, int index) throws Exception {
        if (index > size) {
            throw new Exception("Index out of range for size " + this.size);
        }

        if (index == this.size) {
            insertLast(val);
            return;
        }

        if (index == 0) {
            insertFirst(val);
            return;
        }

        Node<T> temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node<T> newNode = new Node<>(val);
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;

    }

    public void insertLast(T val) {
        if (this.head == null) {
            this.head = new Node<>(val);
            this.head.data = val;
            this.tail = head;
            this.size++;
            return;
        }
        Node<T> temp = new Node<>(val);
        this.tail.next = temp;
        this.tail = temp;
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public T getFirst() {
        if (this.head == null) {
            return null;
        }

        return this.head.data;
    }

    public T get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(
                    "Cannot remove element at index '" + index + "' from Linked List of size '" + this.size + "'");
        }

        if (index == 0) {
            return this.head.data;
        } else if (index == this.size - 1) {
            return this.tail.data;
        }

        Node<T> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public T getLast() {
        if (this.head == null) {
            return null;
        }

        return this.tail.data;
    }

    public void removeFirst() throws Exception {
        if (this.head == null) {
            throw new Exception("Cannot delete from an empty Linked List");
        }

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        this.size--;
    }

    public void remove(int index) throws Exception {
        if (this.head == null) {
            throw new Exception("Cannot delete from an empty Linked List");
        }

        if (index >= this.size) {
            throw new IndexOutOfBoundsException(
                    "Cannot remove element at index '" + index + "' from Linked List of size '" + this.size + "'");
        }

        if (index == 0) {
            removeFirst();
            return;
        } else if (index == this.size - 1) {
            removeLast();
            return;
        }

        Node<T> temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        this.size--;
    }

    public void removeLast() throws Exception {
        if (this.head == null) {
            throw new Exception("Cannot delete from an empty Linked List");
        }
        if (this.head.next == null) {
            removeFirst();
            return;
        }

        Node<T> temp = this.head;
        while (temp.next != this.tail) {
            temp = temp.next;
        }
        temp.next = null;
        this.tail = temp;
        this.size--;
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append(temp.data + " -> ");
            temp = temp.next;
        }
        builder.append("null");
        return builder.toString();
    }
}
