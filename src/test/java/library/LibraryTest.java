package library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LibraryTest {

    @Test
    void 책을_등록하고_제목으로_찾을_수_있다() {
        Library library = new Library();
        Book book = new Book("자바의 정석", "남궁성");

        library.registerBook(book);

        Book findBook = library.findByTitle("자바의 정석");

        assertThat(findBook).isSameAs(book);
    }

    @Test
    void 회원을_등록하고_찾을_수_있다() {
        Library library = new Library();
        Member member = new Member("철수");

        library.registerMember(member);

        Member findMember = library.findByMember("철수");

        assertThat(findMember).isSameAs(member);
    }

    @Test
    void 책을_대출할_수_있다() {
        Library library = new Library();
        Book book = new Book("자바의 정석", "남궁성");
        Member member = new Member("철수");

        library.registerBook(book);
        library.registerMember(member);

        library.borrowBook("철수", "자바의 정석");

        assertThat(book.isBorrowed()).isTrue();
        assertThat(member.getBorrowedBooks()).contains(book);
    }

    @Test
    void 이미_대출중인_책은_다시_대출할_수_없다() {
        Library library = new Library();
        Book book = new Book("자바의 정석", "남궁성");
        Member member1 = new Member("철수");
        Member member2 = new Member("영희");

        library.registerBook(book);
        library.registerMember(member1);
        library.registerMember(member2);

        library.borrowBook("철수", "자바의 정석");

        assertThatThrownBy(() ->
                library.borrowBook("영희", "자바의 정석")
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 대출한_책을_반납할_수_있다() {
        Library library = new Library();
        Book book = new Book("자바의 정석", "남궁성");
        Member member = new Member("철수");

        library.registerBook(book);
        library.registerMember(member);

        library.borrowBook("철수", "자바의 정석");
        library.returnBook("철수", "자바의 정석");

        assertThat(book.isBorrowed()).isFalse();
        assertThat(member.getBorrowedBooks()).doesNotContain(book);
    }

    @Test
    void 자신이_대출하지_않은_책은_반납할_수_없다() {
        Library library = new Library();
        Book book = new Book("자바의 정석", "남궁성");
        Member member = new Member("철수");

        library.registerBook(book);
        library.registerMember(member);

        assertThatThrownBy(() ->
                library.returnBook("철수", "자바의 정석")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 존재하지_않는_회원은_대출할_수_없다() {
        Library library = new Library();
        Book book = new Book("자바의 정석", "남궁성");

        library.registerBook(book);

        assertThatThrownBy(() ->
                library.borrowBook("철수", "자바의 정석")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}