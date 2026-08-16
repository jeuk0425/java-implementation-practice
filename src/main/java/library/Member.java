package library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final List<Book> borrowedBooks;

    public Member(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        this.name = name;
        this.borrowedBooks = new ArrayList<>();

    }
    public void addBorrowedBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("책은 null일 수 없습니다.");
        }
        if (borrowedBooks.contains(book)) {
            throw new IllegalStateException("이미 대출 중인 책입니다.");
        }
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("책은 null일 수 없습니다.");
        }

        if (!borrowedBooks.remove(book)) {
            throw new IllegalArgumentException("대출하지 않은 책 입니다.");
        }
    }
    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return List.copyOf(borrowedBooks);
    }
}
