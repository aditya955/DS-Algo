package DataStructure;
import java.util.ArrayList;

public class Trees<T> {
    class Node<U> {
        U data;
        ArrayList<Node<U>> next;

        Node(U data, Node<U>[] nextArr) {
            this.data = data;
            this.next = new ArrayList<>();

            if(nextArr != null)
                for(Node<U> n: nextArr) {
                    this.next.add(n);
                }
        }
    }

    Node<T> root;

    public Trees() {}

    // seq = sequence which is to be followed to add new element
    // if seq = 131, then new element will be added after traversing tree:
    //      root -> index 1 child
    //      index 1 child to index 3 child
    //      element will be added as index 1 child for index 3 child
    public void insert(T data, String seq) throws Exception {
        if(this.root == null || seq.isEmpty()) {
            this.root = new Node<T>(data, null);
            return;
        }

        Node<T> temp = this.root;
        
        for(int i = 0; i < seq.length() - 1; i++) {
            try {
                char ch = seq.charAt(i);
                temp = temp.next.get((int) (ch - '0'));
            } catch(IndexOutOfBoundsException e) {
                throw new Exception("Cannot access child at given index");
            }
        }

        int insertAt = (int) (seq.charAt(seq.length() - 1) - '0');
        if(temp.next.size() == insertAt) {
            temp.next.add(new Node<T>(data, null));
        } else if(temp.next.size() < insertAt) {
            throw new Exception("Cannot insert at " + insertAt + " index, total child nodes: " + temp.next.size());
        } else {
            temp.next.set(insertAt, new Node<T>(data, null));
        }
    }

    public void inorder() {
        inorder(this.root);
    }

    private void inorder(Node<T> curr) {
        if(curr == null) {
            return;
        }

        if(curr.next.size() == 0) {
            System.out.println(curr.data);
        }
        for(int i = 0; i < curr.next.size(); i++) {
            inorder(curr.next.get(i));
            if(i == 0)
                System.out.println(curr.data);
        }
    }
    
    public void preorder() {
        preorder(this.root);
    }

    private void preorder(Node<T> curr) {
        if(curr == null) {
            return;
        }
        
        System.out.println(curr.data);
        for(int i = 0; i < curr.next.size(); i++) {
            preorder(curr.next.get(i));
        }
    }

    public void postorder() {
        postorder(this.root);
    }

    private void postorder(Node<T> curr) {
        if(curr == null) {
            return;
        }

        for(int i = 0; i < curr.next.size(); i++) {
            postorder(curr.next.get(i));
        }
        System.out.println(curr.data + " ");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("NOT IMPLEMENTED YET!!!");

        return builder.toString();
    }
}
