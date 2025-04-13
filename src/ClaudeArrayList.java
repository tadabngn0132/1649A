/**
 * ClaudeArrayList - Triển khai ArrayList tự viết
 * Mô phỏng ArrayList trong Java với các chức năng cơ bản
 */
public class ClaudeArrayList<E> {
    // Mảng lưu trữ dữ liệu
    private Object[] elementData;
    // Kích thước thực tế của list
    private int size;
    // Kích thước mặc định
    private static final int DEFAULT_CAPACITY = 10;
    // Mảng rỗng
    private static final Object[] EMPTY_ELEMENTDATA = {};


    /**
     * Khởi tạo một ArrayList rỗng với dung lượng mặc định
     */
    public ClaudeArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }


    /**
     * Khởi tạo một ArrayList với dung lượng ban đầu được chỉ định
     */
    public ClaudeArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Dung lượng không hợp lệ: " + initialCapacity);
        }
        this.size = 0;
    }


    /**
     * Trả về số lượng phần tử trong list
     */
    public int size() {
        return size;
    }


    /**
     * Kiểm tra list có rỗng không
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Thêm một phần tử vào cuối list
     */
    public boolean add(E e) {
        // Đảm bảo dung lượng đủ
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }


    /**
     * Thêm một phần tử vào vị trí chỉ định
     */
    public void add(int index, E element) {
        // Kiểm tra index hợp lệ
        rangeCheckForAdd(index);
       
        // Đảm bảo dung lượng đủ
        ensureCapacity(size + 1);
       
        // Di chuyển tất cả phần tử từ index trở đi sang phải một vị trí
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }


    /**
     * Lấy phần tử tại vị trí chỉ định
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        // Kiểm tra index hợp lệ
        rangeCheck(index);
        return (E) elementData[index];
    }


    /**
     * Cập nhật giá trị tại vị trí chỉ định
     */
    public E set(int index, E element) {
        // Kiểm tra index hợp lệ
        rangeCheck(index);
       
        @SuppressWarnings("unchecked")
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }


    /**
     * Xóa phần tử tại vị trí chỉ định
     */
    public E remove(int index) {
        rangeCheck(index);


        @SuppressWarnings("unchecked")
        E oldValue = (E) elementData[index];


        // Tính toán số phần tử cần di chuyển
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // Di chuyển các phần tử sau index lên một vị trí
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        // Để tránh memory leak, gán null cho phần tử cuối cùng
        elementData[--size] = null;


        return oldValue;
    }


    /**
     * Xóa phần tử chỉ định (phần tử đầu tiên tìm thấy)
     */
    public boolean remove(Object o) {
        if (o == null) {
            // Tìm và xóa phần tử null đầu tiên
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            // Tìm và xóa phần tử bằng o đầu tiên
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Xóa nhanh phần tử tại vị trí chỉ định (không kiểm tra và không trả về giá trị cũ)
     */
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }


    /**
     * Kiểm tra xem list có chứa phần tử chỉ định không
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    /**
     * Tìm vị trí đầu tiên của phần tử trong list
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * Tìm vị trí cuối cùng của phần tử trong list
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * Xóa tất cả phần tử trong list
     */
    public void clear() {
        // Xóa tham chiếu để GC có thể giải phóng bộ nhớ
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }


    /**
     * Đảm bảo mảng có đủ dung lượng
     */
    private void ensureCapacity(int minCapacity) {
        // Nếu cần dung lượng lớn hơn kích thước mảng hiện tại
        if (minCapacity > elementData.length) {
            // Tính toán kích thước mới
            int newCapacity = Math.max(elementData.length * 2, minCapacity);
            // Tạo mảng mới và sao chép dữ liệu
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }


    /**
     * Kiểm tra index hợp lệ trong phạm vi
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    /**
     * Kiểm tra index hợp lệ để thêm phần tử
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    /**
     * Trả về chuỗi biểu diễn của list
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }


    /**
     * Ví dụ sử dụng lớp ClaudeArrayList
     */
    public static void main(String[] args) {
        // Tạo ArrayList mới
        ClaudeArrayList<String> list = new ClaudeArrayList<>();
    
        // Thêm phần tử
        list.add("Java");
        list.add("Python");
        list.add("C++");
    
        // In ra kích thước và nội dung
        System.out.println("Kích thước: " + list.size());
        System.out.println("Danh sách: " + list);
    
        // Chèn phần tử mới
        list.add(1, "JavaScript");
        System.out.println("Sau khi chèn: " + list);
    
        // Cập nhật phần tử
        list.set(0, "Java Core");
        System.out.println("Sau khi cập nhật: " + list);
    
        // Xóa phần tử
        list.remove(2);
        System.out.println("Sau khi xóa: " + list);
    
        // Tìm kiếm phần tử
        System.out.println("Vị trí của 'JavaScript': " + list.indexOf("JavaScript"));
        System.out.println("Có chứa 'C++' không? " + list.contains("C++"));
    }
}
