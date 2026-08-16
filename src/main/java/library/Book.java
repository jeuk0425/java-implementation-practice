package library;

public class Book {

    private final String title;
    private final String author;
    private boolean borrowed;

    public Book(String title, String author) {
        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("제목은 비어 있을 수 없습니다.");
        }
        if(author == null || author.isBlank()) {
            throw new IllegalArgumentException("저자는 비어 있을 수 없습니다.");
        }

        this.title = title;
        this.author = author;
        this.borrowed = false;


    }

    public void borrow() {
        if (borrowed) {
            throw new IllegalStateException("이미 대출 중인 책입니다.");
        }
        borrowed = true;
    }

    public void returnBook() {
        if (!borrowed) {
            throw new IllegalStateException("대출되지 않은 책입니다.");
        }
        borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
}
