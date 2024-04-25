package AssignmentTwo.library_system;

public class Book {

    private String title;
    private String author;
    private Integer quantity;

    public Book(String title, String author, Integer quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void borrowBook(Integer quantity) {
        this.quantity -= quantity;
    }

    public void returnBook(Integer quantity) {
        this.quantity += quantity;
    }
}
