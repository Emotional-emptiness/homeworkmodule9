public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
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

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return front.value;
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }

        Object value = front.value;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return value;
    }

    private boolean isEmpty() {
        return size == 0;
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
