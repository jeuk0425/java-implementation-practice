package library;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BookTest {

    @Test
    void 정상적인책생성() {

        Book book = new Book("title", "author");

        assertThat(book.getTitle()).isEqualTo("title");
        assertThat(book.getAuthor()).isEqualTo("author");
        assertThat(book.isBorrowed()).isFalse();
    }

    @Test
    void 제목이null이면예외발생() {
        assertThatThrownBy(() -> new Book(" ", "author"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("제목은 비어 있을 수 없습니다.");
    }

    @Test
    void 저자가공백이면예외발생() {
        assertThatThrownBy(()->new Book("title", " "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("저자는 비어 있을 수 없습니다.");
    }

    @Test
    void 책을대출하면대출상태가된다() {
        Book book = new Book("title", "author");

        book.borrow();

        assertThat(book.isBorrowed()).isTrue();
    }
    @Test
    void 이미대출된책을대출하면예외발생() {
        Book book = new Book("title", "author");
        book.borrow();

        assertThatThrownBy(() -> book.borrow())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 대출 중인 책입니다.");
    }
    @Test
    void 대출된책을반납하면대출상태가해제된다() {
        Book book = new Book("title", "author");
        book.borrow();

        book.returnBook();

        assertThat(book.isBorrowed()).isFalse();
    }
    @Test
    void 대출되지않은책을반납하면예외발생() {
        Book book = new Book("title", "author");
        assertThatThrownBy(() -> book.returnBook())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("대출되지 않은 책입니다.");
    }
}
