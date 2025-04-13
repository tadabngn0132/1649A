// Lưu thông tin sách
public class Book {
    // Khai báo biến    
    private String id; // Mã sách kiểu String cho nó linh hoạt, được cả chữ cả số. Kiểu như mã sinh viên GDH220895.
    private String title;
    private String author;
    private double price; // Để kiểu double để lưu được số thập phân (có phải giá nào cũng tròn trĩnh đâu haha)
    private int quantity;


    // Constuctor khởi tạo đối tượng Book
    public Book(String id, String title, String author,
                double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }


    // Để private thì phải có getter để đọc được giá trị thuốc tính
    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
