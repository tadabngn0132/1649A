public class TestMyArrayList {
    public static void main(String[] args) {
        // Tạo một MyArrayList để chứa các chuỗi
        MyArrayList<String> list = new MyArrayList<>();
        
        // Thêm các phần tử vào cuối danh sách
        list.add("Java");
        list.add("Python");
        list.add("C++");
        
        // In ra kích thước và nội dung
        System.out.println("Size: " + list.size());
        list.printAll();
        list.printAllExistElement();
        
        // Chèn phần tử vào vị trí 1
        list.insert(1, "JavaScript");
        System.out.print("After insert: ");
        list.printAll();
        System.out.print("After insert: ");
        list.printAllExistElement();
        
        // Lấy và hiển thị phần tử ở vị trí 2
        System.out.println("Element at index 2: " + list.get(2));
        
        // Cập nhật phần tử ở vị trí 0
        list.set(0, "Java Core");
        list.printAll();
        list.printAllExistElement();
        
        // Xóa phần tử ở vị trí 2
        String removed = list.remove(2);
        System.out.println("Deleted element: " + removed);
        System.out.print("After delete: ");
        list.printAll();
        System.out.print("After delete: ");
        list.printAllExistElement();
        
        // Tìm kiếm phần tử
        System.out.println("Index of 'JavaScript': " + list.indexOf("JavaScript"));
        System.out.println("Does list contain 'C++'? " + list.contains("C++"));
        System.out.println("Does list contain 'Python'? " + list.contains("Python"));
        
        // Xóa tất cả phần tử
        list.clear();
        System.out.print("After delete all: ");
        list.printAll();
        System.out.print("After delete all: ");
        list.printAllExistElement();
        System.out.println("List is empty? " + list.isEmpty());
    }
}