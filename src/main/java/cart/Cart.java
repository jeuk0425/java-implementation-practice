package cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products = new ArrayList<>();

    public final List<Product> getProducts() {
        return List.copyOf(products);//현재상품들을 수정할 수 없는 새 목록으로 반환
    }

    //내가 제일 부족한 것 : 메서드 사이에서 값을 전달하는 흐름, 즉 매개변수(parameter)에 대한 감각
    public void addProduct(Product product) {
        validateAddProduct(product);
        products.add(product);
    }

    private void validateAddProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("상품을 다시 넣어주세요.");
        }
    }
    /* 장바구니총액계산
    private void totalPriceCart() {
    }
    이렇게 선언하면안됨. 이 로직에서 private을쓰면 외부테스트호출불가능, 그리고 void를쓰면 계산총액반환불가능
     */
    public int calculateTotalPrice() {
        int totalPrice = 0;
        // products에서 Product를 하나씩 꺼낸다
        // 각 상품의 calculateTotalPrice() 결과를 totalPrice에 더한다
        for (Product product : products) {
            totalPrice+=product.calculateTotalPrice();
        }
        return totalPrice;
    }




}
