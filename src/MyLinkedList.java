public class MyLinkedList<T> {
    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constuctor khởi tạo linked list
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Kiểm tra xem linked list có rỗng không
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

    // Thêm phần tử vào vị trí tùy chọn
    public void addAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }

        if (index == 0) {
            addFirst(data);
        }

        if (index == size) {
            add(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node newNodeAtIdxNode = new Node(data);
        newNodeAtIdxNode.next = current.next;
        current.next = newNodeAtIdxNode;
        size++;
    }

    // Xóa phần tử đầu tiên
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Linkedlist is empty.");
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
            throw new RuntimeException("Linked list is empty.");
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

    public T removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }
        
        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            removeLast();
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

    // Lấy phần tử tại vị trí tùy chọn
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Tìm kiếm vị trí của phần tử đầu tiên có giá trị cần tìm
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

        return -1;
    }

    
    // Kiểm tra xem danh sách có chứa phần tử không
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
    
    // Cập nhật giá trị tại vị trí chỉ định
    public void set(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        current.data = data;
    }

    // In toàn bộ danh sách
    public void printAll() {
        Node current = head;
        
        while (current.next != null) {
            System.out.println(current.data + ", ");
            current = current.next;
        }

        System.out.println(current.data);
    }
    
    // Xóa toàn bộ danh sách
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
