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