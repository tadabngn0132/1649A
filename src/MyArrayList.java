import java.util.Arrays;

public class MyArrayList<T> {
    //Type parameter T is used to define a generic class

    // MyArrayList is an Abstract Data Type (ADT)
    // that encapsulates its underlying data structure and its operations
    private T[] arr;
    private int count;

    // Constructer mặc định với kích thước khởi tạo = 10
    public MyArrayList() {
        arr = (T[]) new Object[10];
        count = 0;
    }

    // Constructer với kích thước tùy chỉnh
    public MyArrayList(int size) {
        arr = (T[]) new Object[size]; // Initialize the array with the given size
        count = 0; // Initialize the count of elements in use
    }

    // Trả về số phần tử hiện có trong danh sách
    public int size(){
        return count;
    }

    // Trả về giá trị boolean, nếu trả về true là mảng trống, ngược lại là không trống
    public boolean isEmpty() {
        return count == 0;
    }

    // Thêm phần tử vào vị trí index
    public void insert(int index, T value) {
        // Kiểm tra index hợp lệ hay không
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + count
            );
        }

        // Kiểm tra và mở rộng mảng gấp đôi nếu cần
        if (count >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }

        // Shift all elements starting from the adding index
        // to the right by one position
        for (int i = count; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        // Gán giá trị mới vào vị trí index
        arr[index] = value;
        count++;
    }


    // Thêm phần tử vào cuối array
    public void add(T value) {
        insert(count, value);
    }


    // Lấy phần tử tại vị trí index
    public T get(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + count
            );
        }

        return arr[index];
    }


    // Cập nhật giá trị tại vị trí index
    public T set(int index, T value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + count
            );
        }

        T oldValue = arr[index];
        arr[index] = value;
        return oldValue;
    }


    // Xóa phần tử tại vị trí index
    public T remove(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + count
            );
        }

        // Lưu lại giá trị cần xóa để trả về
        T removedValue = arr[index];

        // Dịch chuyển các phần tử sang trái 1 vị trí
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Xóa tham chiếu đến phần tử cuối để tránh memory leak
        arr[count - 1] = null;
        count--;

        return removedValue;
    }

    // Tìm vị trí đầu tiên của phần tử
    public int indexOf(T value) {
        if (value == null) {
            throw new NullPointerException("Value can not be null");
        } else {
            for (int i = 0; i < count; i++) {
                if (value == arr[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            arr[i] = null;
        }
        count = 0;
    }

    public void printAll(){
        // In toàn bộ mảng
        System.out.println(Arrays.toString(arr));
    }

    public void printAllExistElement() {
        // In ra chỉ các phần tử đang được dùng
        for(int i=0; i<count; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
