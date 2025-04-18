import java.util.NoSuchElementException;

public class LinkedlistBasedStack<T> {
    private MyLinkedList<T> items;
    private int top;

    public LinkedlistBasedStack(int size) {
        items = new MyLinkedList<>();
        top = -1;
    }

    public void push(T item) {
        items.add(item);
        top++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        T item = items.get(top);
        items.removeAt(top);
        top--;

        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        
        return items.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
