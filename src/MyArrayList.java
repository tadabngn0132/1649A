import java.util.Arrays;

public class MyArrayList<T> {
    //Type parameter T dùng để định nghĩa một lớp generic
    
    // MyArrayList là một Abstract Data Type (ADT)
    // đóng gói cấu trúc dữ liệu và các phép toán
    private T[] arr;
    private int count;

    // Constructor mặc định với kích thước ban đầu = 10
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        arr = (T[]) new Object[10];
        count = 0;
    }

    // Constructer với kích thước tùy chỉnh
    @SuppressWarnings("unchecked")
    public MyArrayList(int size) {
        if (size <= 0) {
            // Trường hợp người dùng nhập kích thước không hợp lệ
            System.out.println("Kích thước không hợp lệ " + size + ", sử dụng giá trị mặc định 10");
            arr = (T[]) new Object[10];
        } else {
            arr = (T[]) new Object[size]; // Khởi tạo mảng với kích thước cho trước
        }
        count = 0; // Ban đầu số lượng phần tử đang dùng là 0
    }

    // Trả về số phần tử hiện có trong danh sách
    public int size(){
        return count;
    }

    // Kiểm tra xem danh sách có rỗng không
    // Trả về true nếu danh sách rỗng, ngược lại là false
    public boolean isEmpty() {
        return count == 0;
    }

    // Độ phức tạp O(n)
    // Chèn phần tử vào vị trí index
    public void addAt(int index, T value) {
        // Kiểm tra index hợp lệ hay không
        if (index < 0 || index > count) {
            System.out.println("Lỗi: Vị trí chèn không hợp lệ: " + index);
            return;
        }

        // Kiểm tra xem mảng có đủ không gian để chứa thêm phần tử không
        if (count >= arr.length) {
            // Nếu mảng đã đầy, tạo mảng mới lớn hơn (gấp đôi)
            arr = Arrays.copyOf(arr, arr.length * 2);
        }

        // Dịch chuyển các phần tử từ vị trí index về sau sang phải
        for (int i = count; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        // Chèn phần tử mới vào vị trí index
        arr[index] = value;
        count++; // Tăng số lượng phần tử lên 1
    }


    // Độ phức tạp O(n) - trong trường hợp xấu nhất
    // Thêm phần tử vào cuối danh sách
    public void add(T value) {
        addAt(count, value);
    }


    // Độ phức tạp O(1)
    // Lấy phần tử tại vị trí index
    public T get(int index) {
        // Kiểm tra index có hợp lệ không
        if (index < 0 || index >= count) {
            System.out.println("Lỗi: Index ngoài phạm vi: " + index);
            return null;
        }

        return arr[index];
    }


    // Độ phức tạp O(1)
    // Cập nhật giá trị tại vị trí index
    public T set(int index, T value) {
        // Kiểm tra index có hợp lệ không
        if (index < 0 || index >= count) {
            System.out.println("Lỗi: Index ngoài phạm vi: " + index);
            return null;
        }

        T oldValue = arr[index];
        arr[index] = value;
        return oldValue;
    }


    // Độ phức tạp O(n)
    // Xóa phần tử tại vị trí index
    public T remove(int index) {
        // Kiểm tra index có hợp lệ không
        if (index < 0 || index >= count) {
            System.out.println("Lỗi: Index ngoài phạm vi: " + index);
            return null;
        }

        // Lưu lại giá trị cần xóa để trả về
        T removedValue = arr[index];

        // Dịch chuyển các phần tử sang trái 1 vị trí
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Gán null cho phần tử cuối cùng
        arr[count - 1] = null;
        count--;

        return removedValue;
    }

    // Độ phức tạp O(n)
    // Tìm vị trí đầu tiên của phần tử
    public int indexOf(T value) {
        if (value == null) {
            // Nếu tìm null thì thông báo rồi trả về -1
            System.out.println("Không hỗ trợ tìm kiếm giá trị null");
            return -1;
        } else {
            // Duyệt qua từng phần tử để tìm
            for (int i = 0; i < count; i++) {
                if (value == arr[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    // Độ phức tạp O(n)
    // Kiểm tra xem danh sách có chứa phần tử không
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    // Độ phức tạp O(n)
    // Xóa tất cả phần tử trong danh sách
    public void clear() {
        // Gán null cho tất cả phần tử
        for (int i = 0; i < count; i++) {
            arr[i] = null;
        }
        count = 0;
    }

    // Độ phức tạp O(n) vì toString có độ phức tạp O(n)
    public void printAll(){
        // In toàn bộ mảng
        System.out.println(Arrays.toString(arr));
    }

    // Độ phức tạp O(n)
    // In các phần tử đang được sử dụng
    public void printAllExistElement() {
        System.out.print("[");
        for(int i=0; i<count; i++){
            System.out.print(arr[i]);
            if (i < count - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();
    }
}
