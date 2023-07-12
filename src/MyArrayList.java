class MyArrayList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(T value) {
        if (size == elements.length) {
            Object[] newElements = new Object[size * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size] = value;
        size++;
    }

    public void clear() {
        elements = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }
}