// Stack ADT (Abstract Data Type) - LIFO (Last In First Out)

import java.util.NoSuchElementException;

public class ArrayBasedStack<T> {
    // Dùng array list vì hiệu quả hơn vì trong trường hợp này số lượng sách trong stack có thể không quá lớn
    // Nhưng khi số lượng phần tử đạt đến giới hạn kích thước mảng, cần tạo mảng mới lớn hơn
    private MyArrayList<T> items;
    private int top;
    private int size;

    // Constructor
    public ArrayBasedStack(int size) {
        this.items = new MyArrayList<>(size);
        this.top = -1;
        this.size = size;
    }

    // Độ phức tạp O(1)
    // Kiếm tra xem stack có trống hay không
    public boolean isEmpty() {
        return top == -1;
    }

    // Độ phức tạp O(1)
    // Kiểm tra xem stack có đầy hay không
    public boolean isFull() {
        return top == size - 1;
    }

    // Độ phức tạp O(1) (trường hợp thông thường)
    // Độ phức tạp O(n) (trường hợp xấu nhất)
    // Thêm phần tử vào stack
    public void push(T item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full.");
        }

        items.add(item);
        top++;
    }

    // Độ phức tạp O(1)
    // Lấy phần tử từ stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        T item = items.get(top);
        items.remove(top);
        top--;

        return item;
    }

    // Độ phức tạp O(1)
    // Xem phần tử đầu stack mà không xóa
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        return items.get(top);
    }

    // Độ phức tạp O(1)
    // Lấy kích thước hiện tại của stack
    public int size() {
        return top + 1;
    }
}
