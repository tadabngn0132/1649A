public class TestArrayBasedStack {
    public static void main(String[] args) {
        ArrayBasedStack<String> bookStack = new ArrayBasedStack<>(15);

        System.out.println();
        System.out.println("Book stack is empty? " + bookStack.isEmpty());
        System.out.println();

        bookStack.push("Perfect Spy");
        bookStack.push("Business Management Theory");

        System.out.println("Book stack is empty? " + bookStack.isEmpty());
        System.out.println("Book stack is full? " + bookStack.isFull());
        System.out.println("Stack size: " + bookStack.size());
        System.out.println("Stack's first element: " + bookStack.peek());
        
        System.out.println();
        System.out.println("Pop from stack: " + bookStack.pop());
        System.out.println("Stack size after pop: " + bookStack.size());

        bookStack.push("Business Management Theory");
        bookStack.push("The Art of War");
        bookStack.push("Atomic Habits");
        bookStack.push("The Lean Startup");
        bookStack.push("Thinking, Fast and Slow");
        bookStack.push("The 7 Habits of Highly Effective People");
        bookStack.push("The Power of Now");
        bookStack.push("Sapiens: A Brief History of Humankind");
        bookStack.push("The Subtle Art of Not Giving a F*ck");
        bookStack.push("Deep Work: Rules for Focused Success");
        bookStack.push("The Psychology of Money");
        bookStack.push("The Alchemist");
        bookStack.push("The Four Agreements");
        bookStack.push("The 48 Laws of Power");

        System.out.println();
        System.out.println("Stack size: " + bookStack.size());
        System.out.println("Book stack is full? " + bookStack.isFull());
    }
}
