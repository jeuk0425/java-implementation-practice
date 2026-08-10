package cart;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    @DisplayName("상품의 총금액계산")
    void 상품의총금액을계산한다() {
        //given
        Product product = new Product("노트북", 1000, 2);
        //when
        int totalPrice = product.calculateTotalPrice();
        //then
        assertThat(totalPrice).isEqualTo(2000);
    }

    @Test
    @DisplayName("상품명이 null이면 예외 발생")
    void 상품명이null이면_예외발생() {
        assertThatThrownBy(() -> new Product(null, 10000, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품명을 입력하세요.");
    }

    @Test
    @DisplayName("상품명이 공백이면 예외발생")
    void 상품명이공백이면_예외발생() {
        assertThatThrownBy(() -> new Product(" ", 10000, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품명을 입력하세요.");
    }

    @Test
    @DisplayName("상품가격이 0원이하면 예외발생")
    void 상품가격0원이하면_예외발생() {
        assertThatThrownBy(() -> new Product("노트북", 0, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품가격을 다시 입력해주세요.");
    }
    @Test
    @DisplayName("상품수량이 0개이하면 예외발생")
    void 상품수량0개이하시_예외발생(){
        assertThatThrownBy(() -> new Product("노트북", 1000, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품수량을 다시 입력해주세요.");
    }
}
