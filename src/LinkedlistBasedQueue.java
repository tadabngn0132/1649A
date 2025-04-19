public class LinkedlistBasedQueue<T> {
    private MyLinkedList<T> items;

    public LinkedlistBasedQueue() {
        items = new MyLinkedList<>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void enqueue(T item) {
        items.add(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }

        return items.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }

        return items.get(0);
    }

    public int size() {
        return items.size();
    }
}
