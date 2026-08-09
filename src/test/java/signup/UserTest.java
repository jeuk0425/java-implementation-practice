package signup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void 정상로직실행() {
        User user = new User("abc1234", "password1234", "jeuk");

        assertDoesNotThrow(() -> {
            user.validateId();
            user.validatePassword();
            user.validateName();
        });
    }
    @Test
    void 아이디가_너무짧으면_예외발생() {
        User user = new User("ab", "password1234", "jeuk");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> user.validateId());

        assertThat(e.getMessage()).isEqualTo("아이디는 5자이상 12자 이하여야합니다.");
    }
    @Test
    void 아이디에대문자가있으면_예외발생() {
        User user = new User("Abcde", "password1234", "jeuk");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> user.validateId());

        assertThat(e.getMessage()).isEqualTo("아이디는 영문 소문자와 숫자만 사용 할 수 있습니다");
    }

    @Test
    void 아이디에공백이있으면_예외발생() {
        User user = new User("ab cde", "password1234", "jeuk");
        assertThrows(IllegalArgumentException.class,
                () -> user.validateId());
    }

    @Test
    void 비밀번호에숫자가없으면_예외발생() {
        User user = new User("abc123", "aaaaaaaaa", "jeuk");
        assertThrows(IllegalArgumentException.class,
                () -> user.validatePassword());
    }

    @Test
    void 이름은공백만있는경우_예외발생() {
        User user = new User("adc123", "password1234", "  ");
        assertThrows(IllegalArgumentException.class,
                () -> user.validateName());
    }
}
