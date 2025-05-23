public class ArrayBasedQueue<T> {
    private MyArrayList<T> items;

    public ArrayBasedQueue(int size) {
        this.items = new MyArrayList<>(size);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Thông thường độ phức tạp O(1)
    // Nếu phải tạo mảng mới thì độ phức tạp O(n)
    public void enqueue(T item) {
        items.add(item);
    }

    // Độ phức tạp O(n)
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Hàng đợi rỗng. Không thể lấy phần tử.");
            return null;
        }

        return items.remove(0);
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Hàng đợi rỗng. Không thể lấy phần tử.");
            return null;
        }

        return items.get(0);
    }

    public int size() {
        return items.size();
    }
}
