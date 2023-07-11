public class MyHashMap {
    private Node[] buckets;
    private int capacity;
    private int size;

    public MyHashMap() {
        capacity = 16; // default capacity
        buckets = new Node[capacity];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node newNode = new Node(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
            size++;
        } else {
            Node current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
                size++;
            }
        }
    }

    public void remove(Object key) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            return;
        }

        Node prev = null;
        Node current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        buckets = new Node[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getIndex(key);

        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    private int getIndex(Object key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

    private class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

