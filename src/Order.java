import java.util.List;

// Lưu trữ thông tin đơn hàng
public class Order {
    // Khai báo biến
    private String id; // Mã đơn hàng cũng để String tương tự Book
    private String customerName;
    private String shippingAddress;
    private List<Book> books; // Khai báo với interface (List) cho phép tính trừu tượng và linh hoạt cao hơn
    private String status;  
    // "Pending", "Processing", "Shipped", "Delivered"

    // Khởi tạo đối tượng Order
    Order(String id, String customerName, String shippingAddress) {
        this.id = id;
        this.customerName = customerName;
        this. shippingAddress = shippingAddress;
        // Lập tình hướng giao diện (List), không hướng triển khai cụ thể
        // Lớp cụ thể (concrete class) triển khai giao diện List
        this.books = new java.util.ArrayList<>(); // Chọn arraylist vì truy cập ngẫu nhiên nhanh, hiểu quả bộ nhớ
        // Dù việc duyệt qua arraylist có độ phức tạp O(n) thì một đơn hàng cũng đâu thể chứa quá nhiều sách
        // thường thì ít là 1-2 cuốn, nhiều thì 5-10 cuốn, còn tầm 50-100 cuốn trở lên thì có vẻ không nhiều, thậm chí là hiếm
        this.status = "Pending"; // Khởi tạo với trạng thái ban đầu
    }

    // Getters và Setters
    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Thêm sách vào đơn hàng
    public void addBook(Book book) {
        books.add(book);
    }
}