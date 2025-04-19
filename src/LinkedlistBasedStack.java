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
            System.out.println("Stack is empty!");
            return null;
        }

        T item = items.get(top);
        items.removeAt(top);
        top--;

        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
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
