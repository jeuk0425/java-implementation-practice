package cart;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CartTest {

    @Test
    void 빈바구니총액은0원() {
        //given
        Cart cart = new Cart();
        //when
        int totalPrice = cart.calculateTotalPrice();
        //then
        assertThat(totalPrice).isEqualTo(0);
    }

    @Test
    void 상품한개의총액계산() {
        //given
        Cart cart = new Cart();
        Product product = new Product("노트북",10000,1);
        cart.addProduct(product);

        //when
        int totalPrice = cart.calculateTotalPrice();
        //then
        assertThat(totalPrice).isEqualTo(10000);

    }

    @Test
    void 여러상품의총액합산() {
        //given
        Cart cart = new Cart();
        Product product1 = new Product("노트북", 10000, 2);
        Product product2 = new Product("마우스", 5000, 1);
        cart.addProduct(product1);
        cart.addProduct(product2);
        //when
        int totalPrice = cart.calculateTotalPrice();
        //then
        assertThat(totalPrice).isEqualTo(25000);
    }

    @Test
    void null상품을추가하면예외발생() {
        Cart cart = new Cart();

        assertThatThrownBy(()->cart.addProduct(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품을 다시 넣어주세요.");
    }
}
