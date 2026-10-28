public class Book {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Method to display book info
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + isAvailable);
    }
}
