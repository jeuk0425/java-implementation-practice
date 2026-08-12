package cart;

public class Product {
    private final String name;
    private final int price;
    private final int quantity;

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;



        //생성자에서 값만저장하고끝내면안됨,-1000원이어도 생성됨 그래서 밑에추가해야함
        validateName();
        validatePrice();
        validateQuantity();

    }

    //계산결과를 반환해야함,
    //현재상품의 총금액
    public int calculateTotalPrice() {
        return price * quantity;
    }

    //상품검증로직들은 Product클래스 내부에서만 사용하므로 public 보다 private이 안전함.
    private void validateName() {
        if (name == null || name.isBlank()) { // isBlank()는 "", " ", " "등 공백을 모두 잡아준다.
            throw new IllegalArgumentException("상품명을 입력하세요.");
        }
    }

    private void validatePrice() {
        if (price <= 0) {
            throw new IllegalArgumentException("상품가격을 다시 입력해주세요.");
        }
    }

    private void validateQuantity() {
        if (quantity <= 0) {
            throw new IllegalArgumentException("상품수량을 다시 입력해주세요.");
        }
    }
}
