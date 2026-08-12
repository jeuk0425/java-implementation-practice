package cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountCalculatorTest {

    @Test
    void 수량이3개이면10퍼센트할인된다() {
        //given
        Product product = new Product("노트북", 10_000, 3);
        Cart cart = new Cart();
        cart.addProduct(product);
        DiscountCalculator discountCalculator = new DiscountCalculator();

        //when
        CalculationResult result = discountCalculator.calculate(cart, false);

        //then
        assertThat(result.getQuantityDiscount()).isEqualTo(3_000);

    }

    @Test
    void 수량이2개이면수량할인이적용되지않는다() {
        //given
        Product product = new Product("노트북", 10_000, 2);

        Cart cart = new Cart();
        cart.addProduct(product);

        DiscountCalculator discountCalculator = new DiscountCalculator();

        //when
        CalculationResult result = discountCalculator.calculate(cart, false);

        //then
        assertThat(result.getQuantityDiscount()).isZero();
        //assertThat(result.getQuantityDiscount()).isEqualTo(0);

    }

    @Test
    void 수량할인대상상품이여러개이면할인액이누적된다() {
        //given
        Product product1 = new Product("마우스", 10_000, 3);
        Product product2 = new Product("키보드", 20_000, 4);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        DiscountCalculator discountCalculator = new DiscountCalculator();

        // when
        CalculationResult result = discountCalculator.calculate(cart, false);

        // then
        assertThat(result.getQuantityDiscount()).isEqualTo(11_000);

    }

    @Test
    void 수량할인후금액이정확히10만원이상이면총액할인이적용된다() {
        // given
        Product product1 = new Product("키보드", 30_000, 3);
        Product product2 = new Product("마우스", 19_000, 1);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        DiscountCalculator calculator = new DiscountCalculator();

        // when
        CalculationResult result = calculator.calculate(cart, false);

        // then
        assertThat(result.getTotalPriceDiscount()).isEqualTo(5_000);
    }

    @Test
    void 수량할인후금액이10만원미만이면총액할인이적용되지않는다() {
        // given
        Product product = new Product("키보드", 30_000, 3);

        Cart cart = new Cart();
        cart.addProduct(product);

        DiscountCalculator calculator = new DiscountCalculator();

        // when
        CalculationResult result = calculator.calculate(cart, false);

        // then
        assertThat(result.getTotalPriceDiscount()).isZero();
    }

    @Test
    void 회원이면앞선할인적용후금액에서회원할인이적용된다() {
        // given
        Product product1 = new Product("키보드", 30_000, 3);
        Product product2 = new Product("마우스", 19_000, 1);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        DiscountCalculator calculator = new DiscountCalculator();

        // when
        CalculationResult result = calculator.calculate(cart, true);

        // then
        assertThat(result.getMemberDiscount()).isEqualTo(2_850);
    }

    @Test
    void 비회원이면회원할인이적용되지않는다() {
        // given
        Product product = new Product("노트북", 100_000, 1);

        Cart cart = new Cart();
        cart.addProduct(product);

        DiscountCalculator calculator = new DiscountCalculator();

        // when
        CalculationResult result = calculator.calculate(cart, false);

        // then
        assertThat(result.getMemberDiscount()).isZero();
    }

    @Test
    void 할인금액의소수점이하는버려진다() {
        // given
        Product product = new Product("볼펜", 333, 3);

        Cart cart = new Cart();
        cart.addProduct(product);

        DiscountCalculator calculator = new DiscountCalculator();

        // when
        CalculationResult result = calculator.calculate(cart, false);

        // then
        assertThat(result.getQuantityDiscount()).isEqualTo(99);
    }
}