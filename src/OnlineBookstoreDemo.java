// Cấu trúc dữ liệu Book (Sách)
class Book {
    private String id;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String id, String title, String author, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters và Setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

// Cấu trúc dữ liệu Order (Đơn hàng)
class Order {
    private String orderId;
    private String customerName;
    private String shippingAddress;
    private java.util.List<Book> books;
    private String status; // "Pending", "Processing", "Shipped", "Delivered"

    public Order(String orderId, String customerName, String shippingAddress) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.books = new java.util.ArrayList<>();
        this.status = "Pending";
    }

    // Getters và Setters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getShippingAddress() { return shippingAddress; }
    public java.util.List<Book> getBooks() { return books; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Thêm sách vào đơn hàng
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", books=" + books +
                ", status='" + status + '\'' +
                '}';
    }
}

// Triển khai Stack ADT (Abstract Data Type)
class Stack<T> {
    private java.util.ArrayList<T> elements;
    private int top;
    private int capacity;

    // Constructor
    public Stack(int capacity) {
        this.elements = new java.util.ArrayList<>(capacity);
        this.top = -1;
        this.capacity = capacity;
    }

    // Kiểm tra xem stack có trống không
    public boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra xem stack có đầy không
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Thêm phần tử vào stack (Push)
    public void push(T item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        elements.add(item);
        top++;
    }

    // Lấy phần tử từ stack (Pop)
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = elements.get(top);
        elements.remove(top);
        top--;
        return item;
    }

    // Xem phần tử đầu stack mà không xóa (Peek)
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.get(top);
    }

    // Lấy kích thước hiện tại của stack
    public int size() {
        return top + 1;
    }
}


// Triển khai Queue ADT (Abstract Data Type) - FIFO (First In First Out)
class Queue<T> {
    private java.util.LinkedList<T> elements;

    // Constructor
    public Queue() {
        this.elements = new java.util.LinkedList<>();
    }

    // Thêm phần tử vào hàng đợi (Enqueue)
    public void enqueue(T item) {
        elements.addLast(item);
    }

    // Lấy phần tử từ hàng đợi (Dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return elements.removeFirst();
    }

    // Xem phần tử đầu hàng đợi mà không xóa (Peek)
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return elements.getFirst();
    }

    // Kiểm tra xem hàng đợi có trống không
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Lấy kích thước hiện tại của hàng đợi
    public int size() {
        return elements.size();
    }
}


// Thuật toán sắp xếp
class SortingAlgorithms {

    // Thuật toán Insertion Sort
    public static void insertionSort(java.util.List<Book> books, String criteria) {
        int n = books.size();
        for (int i = 1; i < n; i++) {
            Book key = books.get(i);
            int j = i - 1;
            
            // Di chuyển các phần tử lớn hơn key về sau 1 vị trí
            if (criteria.equals("title")) {
                while (j >= 0 && books.get(j).getTitle().compareTo(key.getTitle()) > 0) {
                    books.set(j + 1, books.get(j));
                    j--;
                }
            } else if (criteria.equals("author")) {
                while (j >= 0 && books.get(j).getAuthor().compareTo(key.getAuthor()) > 0) {
                    books.set(j + 1, books.get(j));
                    j--;
                }
            } else if (criteria.equals("price")) {
                while (j >= 0 && books.get(j).getPrice() > key.getPrice()) {
                    books.set(j + 1, books.get(j));
                    j--;
                }
            }
            
            books.set(j + 1, key);
        }
    }

    // Thuật toán Quick Sort
    public static void quickSort(java.util.List<Book> books, int low, int high, String criteria) {
        if (low < high) {
            int pivotIndex = partition(books, low, high, criteria);
            quickSort(books, low, pivotIndex - 1, criteria);
            quickSort(books, pivotIndex + 1, high, criteria);
        }
    }

    private static int partition(java.util.List<Book> books, int low, int high, String criteria) {
        Book pivot = books.get(high);
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            boolean shouldSwap = false;
            
            if (criteria.equals("title")) {
                shouldSwap = books.get(j).getTitle().compareTo(pivot.getTitle()) <= 0;
            } else if (criteria.equals("author")) {
                shouldSwap = books.get(j).getAuthor().compareTo(pivot.getAuthor()) <= 0;
            } else if (criteria.equals("price")) {
                shouldSwap = books.get(j).getPrice() <= pivot.getPrice();
            }
            
            if (shouldSwap) {
                i++;
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }
        
        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);
        
        return i + 1;
    }
}


// Thuật toán tìm kiếm
class SearchAlgorithms {

    // Thuật toán Linear Search - Tìm kiếm tuần tự
    public static Order linearSearch(java.util.List<Order> orders, String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null; // Không tìm thấy
    }

    // Thuật toán Binary Search - Tìm kiếm nhị phân (yêu cầu danh sách đã được sắp xếp)
    public static Order binarySearch(java.util.List<Order> orders, String orderId) {
        // Sắp xếp danh sách theo orderId trước khi tìm kiếm
        orders.sort((o1, o2) -> o1.getOrderId().compareTo(o2.getOrderId()));
    
        int left = 0;
        int right = orders.size() - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
        
            // Kiểm tra nếu orderId nằm ở giữa
            if (orders.get(mid).getOrderId().equals(orderId)) {
                return orders.get(mid);
            }
        
            // Nếu orderId lớn hơn, bỏ qua nửa bên trái
            if (orders.get(mid).getOrderId().compareTo(orderId) < 0) {
                left = mid + 1;
            }
            // Nếu orderId nhỏ hơn, bỏ qua nửa bên phải
            else {
                right = mid - 1;
            }
        }
    
        return null; // Không tìm thấy
    }
}


// Hệ thống quản lý đơn hàng
class OrderManagementSystem {
    private Queue<Order> orderQueue;
    private java.util.List<Order> processedOrders;

    public OrderManagementSystem() {
        this.orderQueue = new Queue<>();
        this.processedOrders = new java.util.ArrayList<>();
    }

    // Thêm đơn hàng mới vào hàng đợi
    public void placeOrder(Order order) {
        orderQueue.enqueue(order);
        System.out.println("Đơn hàng #" + order.getOrderId() + " đã được thêm vào hàng đợi.");
    }

    // Xử lý đơn hàng từ hàng đợi
    public void processNextOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("Không có đơn hàng nào trong hàng đợi.");
            return;
        }
    
        Order order = orderQueue.dequeue();
        order.setStatus("Processing");
    
        // Sắp xếp sách trong đơn hàng theo tiêu chí
        SortingAlgorithms.insertionSort(order.getBooks(), "title");
    
        order.setStatus("Shipped");
        processedOrders.add(order);
    
        System.out.println("Đơn hàng #" + order.getOrderId() + " đã được xử lý và chuyển sang trạng thái: " + order.getStatus());
    }

    // Tìm kiếm đơn hàng theo ID
    public Order findOrder(String orderId) {
        // Tìm kiếm trong danh sách đã xử lý
        Order foundOrder = SearchAlgorithms.linearSearch(processedOrders, orderId);
    
        if (foundOrder != null) {
            System.out.println("Đã tìm thấy đơn hàng #" + orderId + " với trạng thái: " + foundOrder.getStatus());
            return foundOrder;
        }
    
        System.out.println("Không tìm thấy đơn hàng #" + orderId);
        return null;
    }

    // Hiển thị tất cả đơn hàng đã xử lý
    public void displayAllProcessedOrders() {
        if (processedOrders.isEmpty()) {
            System.out.println("Không có đơn hàng nào đã được xử lý.");
            return;
        }
    
        System.out.println("Danh sách đơn hàng đã xử lý:");
        for (Order order : processedOrders) {
            System.out.println(order);
        }
    }

    // Lấy số lượng đơn hàng trong hàng đợi
    public int getQueueSize() {
        return orderQueue.size();
    }

    // Lấy số lượng đơn hàng đã xử lý
    public int getProcessedOrdersCount() {
        return processedOrders.size();
    }
}

// Lớp Demo để kiểm tra hệ thống
public class OnlineBookstoreDemo {
    public static void main(String[] args) {
        // Khởi tạo hệ thống quản lý đơn hàng
        OrderManagementSystem orderSystem = new OrderManagementSystem();
    
        // Tạo một số sách
        Book book1 = new Book("B001", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 120000, 1);
        Book book2 = new Book("B002", "Số Đỏ", "Vũ Trọng Phụng", 150000, 2);
        Book book3 = new Book("B003", "Truyện Kiều", "Nguyễn Du", 180000, 1);
        Book book4 = new Book("B004", "Nhà Giả Kim", "Paulo Coelho", 200000, 3);
        Book book5 = new Book("B005", "Tắt Đèn", "Ngô Tất Tố", 110000, 2);
    
        // Tạo đơn hàng 1
        Order order1 = new Order("ORD001", "Nguyễn Văn A", "123 Đường Lê Lợi, Quận 1, TP.HCM");
        order1.addBook(book1);
        order1.addBook(book4);
    
        // Tạo đơn hàng 2
        Order order2 = new Order("ORD002", "Trần Thị B", "456 Đường Nguyễn Huệ, Quận 1, TP.HCM");
        order2.addBook(book2);
        order2.addBook(book3);
        order2.addBook(book5);
    
        // Tạo đơn hàng 3
        Order order3 = new Order("ORD003", "Lê Văn C", "789 Đường Hai Bà Trưng, Quận 3, TP.HCM");
        order3.addBook(book1);
        order3.addBook(book5);
    
        // Thêm đơn hàng vào hệ thống
        System.out.println("=== THÊM ĐƠN HÀNG VÀO HỆ THỐNG ===");
        orderSystem.placeOrder(order1);
        orderSystem.placeOrder(order2);
        orderSystem.placeOrder(order3);
    
        System.out.println("\nSố đơn hàng trong hàng đợi: " + orderSystem.getQueueSize());
    
        // Xử lý đơn hàng
        System.out.println("\n=== XỬ LÝ ĐƠN HÀNG ===");
        orderSystem.processNextOrder();
        orderSystem.processNextOrder();
    
        System.out.println("\nSố đơn hàng trong hàng đợi: " + orderSystem.getQueueSize());
        System.out.println("Số đơn hàng đã xử lý: " + orderSystem.getProcessedOrdersCount());
    
        // Hiển thị đơn hàng đã xử lý
        System.out.println("\n=== DANH SÁCH ĐƠN HÀNG ĐÃ XỬ LÝ ===");
        orderSystem.displayAllProcessedOrders();
    
        // Tìm kiếm đơn hàng
        System.out.println("\n=== TÌM KIẾM ĐƠN HÀNG ===");
        orderSystem.findOrder("ORD001");
        orderSystem.findOrder("ORD004"); // Đơn hàng không tồn tại
    
        // Demo Stack
        System.out.println("\n=== DEMO STACK ===");
        Stack<String> bookStack = new Stack<>(5);
        System.out.println("Stack trống: " + bookStack.isEmpty());
    
        bookStack.push("Dế Mèn Phiêu Lưu Ký");
        bookStack.push("Số Đỏ");
        bookStack.push("Truyện Kiều");
    
        System.out.println("Kích thước Stack: " + bookStack.size());
        System.out.println("Phần tử đầu Stack: " + bookStack.peek());
    
        System.out.println("Pop từ Stack: " + bookStack.pop());
        System.out.println("Kích thước Stack sau khi Pop: " + bookStack.size());
    }
}