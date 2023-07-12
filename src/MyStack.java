
import java.util.NoSuchElementException;

class MyStack<T> {
    private Node<T> top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.value;
    }

    public T pop() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}