import java.util.Arrays;


class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[16];
        size = 0;
    }

    public void put(K key, V value) {
        if (size == buckets.length) {
            resize();
        }
        putValue(key, value);
        size++;
    }

    private void resize() {
        Node<K, V>[] newArrayNode = Arrays.copyOf(buckets, buckets.length);
        buckets = new Node[buckets.length * 2];
        for (Node<K, V> kvNode : newArrayNode) {
            if (kvNode != null) {
                putValue(kvNode.key, kvNode.value);
            }
        }
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void clear() {
        buckets = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private void putValue(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);
        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node<K, V> current = buckets[index];
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
            }
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
