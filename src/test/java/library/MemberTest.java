package library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {
    @Test
    void 정상적인회원생성() {
        Member member = new Member("member1");

        assertThat(member.getName()).isEqualTo("member1");
        assertThat(member.getBorrowedBooks()).isEmpty();
    }
    @Test
    void 이름이공백이면예외발생() {
        assertThatThrownBy(() -> new Member(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 대출한책을목록에추가() {
        Member member = new Member("member1");
        Book book = new Book("title", "author");

        member.addBorrowedBook(book);

        assertThat(member.getBorrowedBooks()).contains(book);
    }
    @Test
    void 대출한책을목록에서제거() {
        Member member = new Member("member1");
        Book book = new Book("title", "author");
        member.addBorrowedBook(book);

        member.removeBorrowedBook(book);

        assertThat(member.getBorrowedBooks()).isEmpty();
    }
    @Test
    void 같은책을두번추가하면예외발생() {
        Member member = new Member("member1");
        Book book = new Book("title", "author");
        member.addBorrowedBook(book);

        assertThatThrownBy(() -> member.addBorrowedBook(book))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 대출 중인 책입니다.");
    }
}
