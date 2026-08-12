package cart;

public class CalculationResult {

    private final int totalPrice;
    private final int quantityDiscount;
    private final int totalPriceDiscount;
    private final int memberDiscount;
    private final int finalPrice;

    public CalculationResult(
            int totalPrice,
            int quantityDiscount,
            int totalPriceDiscount,
            int memberDiscount,
            int finalPrice
    ) {
        this.totalPrice = totalPrice;
        this.quantityDiscount = quantityDiscount;
        this.totalPriceDiscount = totalPriceDiscount;
        this.memberDiscount = memberDiscount;
        this.finalPrice = finalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getQuantityDiscount() {
        return quantityDiscount;
    }

    public int getTotalPriceDiscount() {
        return totalPriceDiscount;
    }

    public int getMemberDiscount() {
        return memberDiscount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }
}