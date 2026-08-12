package cart;

public class DiscountCalculator {

    public CalculationResult calculate(Cart cart, boolean isMember) {
        int totalPrice = cart.calculateTotalPrice();

        int quantityDiscount = calculateQuantityDiscount(cart);
        int priceAfterQuantityDiscount = totalPrice - quantityDiscount;

        int totalPriceDiscount =
                calculateTotalPriceDiscount(priceAfterQuantityDiscount);
        int priceAfterTotalDiscount =
                priceAfterQuantityDiscount - totalPriceDiscount;

        int memberDiscount =
                calculateMemberDiscount(priceAfterTotalDiscount, isMember);
        int finalPrice = priceAfterTotalDiscount - memberDiscount;

        return new CalculationResult(totalPrice,quantityDiscount,totalPriceDiscount,memberDiscount,finalPrice);
    }

    private int calculateQuantityDiscount(Cart cart) {
        int discountAmount = 0;

        for (Product product : cart.getProducts()) {
            if (product.getQuantity() >= 3) {
                discountAmount += product.calculateTotalPrice() * 10 / 100;
            }
        }

        return discountAmount;
    }

    private int calculateTotalPriceDiscount(int priceAfterQuantityDiscount) {
        if (priceAfterQuantityDiscount >= 100_000) {
            return priceAfterQuantityDiscount * 5 / 100;
        }

        return 0;
    }

    private int calculateMemberDiscount(
            int priceAfterTotalDiscount,
            boolean isMember
    ) {
        if (isMember) {
            return priceAfterTotalDiscount * 3 / 100;
        }

        return 0;
    }
}