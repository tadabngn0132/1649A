public class ClaudeLinkedList<T> {
    // Định nghĩa lớp Node bên trong
    private class Node {
        T data;
        Node next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    // Khởi tạo LinkedList trống
    public ClaudeLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // Kiểm tra LinkedList có rỗng không
    public boolean isEmpty() {
        return head == null;
    }
    
    // Lấy kích thước của danh sách
    public int size() {
        return size;
    }
    
    // Thêm phần tử vào cuối danh sách
    public void add(T data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }
    
    // Thêm phần tử vào đầu danh sách
    public void addFirst(T data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        size++;
    }
    
    // Thêm phần tử vào vị trí chỉ định
    public void addAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        if (index == size) {
            add(data);
            return;
        }
        
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    // Xóa phần tử đầu tiên
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("LinkedList is empty");
        }
        
        T data = head.data;
        head = head.next;
        size--;
        
        if (head == null) {
            tail = null;
        }
        
        return data;
    }
    
    // Xóa phần tử cuối cùng
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("LinkedList is empty");
        }
        
        if (head == tail) {
            return removeFirst();
        }
        
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        
        T data = tail.data;
        tail = current;
        tail.next = null;
        size--;
        
        return data;
    }
    
    // Xóa phần tử tại vị trí chỉ định
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        if (index == size - 1) {
            return removeLast();
        }
        
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        
        return data;
    }
    
    // Lấy phần tử tại vị trí chỉ định
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    // Tìm kiếm vị trí của phần tử đầu tiên
    public int indexOf(T data) {
        Node current = head;
        int index = 0;
        
        while (current != null) {
            if ((data == null && current.data == null) || 
                (data != null && data.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1; // Không tìm thấy
    }
    
    // Kiểm tra xem danh sách có chứa phần tử không
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
    
    // Cập nhật giá trị tại vị trí chỉ định
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        current.data = data;
    }
    
    // Chuyển LinkedList thành chuỗi
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        
        result.append("]");
        return result.toString();
    }
    
    // Xóa toàn bộ danh sách
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}