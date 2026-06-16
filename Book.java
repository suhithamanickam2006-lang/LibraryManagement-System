package library;

public class Book {
    int id;
    String title;
    String author;
    boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public void displayBook() {
        System.out.println(id + " " + title + " " + author +
                " Issued: " + issued);
    }
}