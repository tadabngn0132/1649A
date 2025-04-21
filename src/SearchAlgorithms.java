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