package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void registerBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("책은 null일 수 없습니다.");
        }

        books.add(book);
    }

    public void registerMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("회원은 null일 수 없습니다.");
        }

        members.add(member);
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Member findByMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void borrowBook(String memberName, String title) {
        Member member = findByMember(memberName);
        Book book = findByTitle(title);

        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        if (book == null) {
            throw new IllegalArgumentException("존재하지 않는 책입니다.");
        }

        book.borrow();
        member.addBorrowedBook(book);
    }
    public void returnBook(String memberName, String title) {
        Member member = findByMember(memberName);
        Book book = findByTitle(title);

        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        if (book == null) {
            throw new IllegalArgumentException("존재하지 않는 책입니다.");
        }

        member.removeBorrowedBook(book);
        book.returnBook();
    }
    public List<Book> getBorrowedBooks(String memberName) {
        Member member = findByMember(memberName);

        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        return member.getBorrowedBooks();
    }
}
