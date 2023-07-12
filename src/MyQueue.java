import java.util.NoSuchElementException;

class MyQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.value;
    }

    public T poll() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = front.value;
        front = front.next;
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
