public class Main {
    public static void main(String[] args) {
        Class[] classes = {MyArrayList.class, MyLinkedList.class, MyStack.class, MyHashMap.class, MyQueue.class};

        for (Class cls : classes) {
            System.out.println(cls.getSimpleName());
        }
    }
}

