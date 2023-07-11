import java.util.EmptyStackException;

public class MyStack {
    private Node top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            top = top.next;
        } else {
            Node currentNode = top;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public Object pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        Object value = top.value;
        top = top.next;
        size--;
        return value;
    }

    private class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
}
