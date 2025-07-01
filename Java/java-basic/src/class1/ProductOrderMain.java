package class1;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder productOrder1 = new ProductOrder();
        productOrder1.productName = "두부";
        productOrder1.price = 2000;
        productOrder1.quantity = 2;

        ProductOrder productOrder2 = new ProductOrder();
        productOrder2.productName = "김치";
        productOrder2.price = 5000;
        productOrder2.quantity = 1;

        ProductOrder productOrder3 = new ProductOrder();
        productOrder3.productName = "콜라";
        productOrder3.price = 1500;
        productOrder3.quantity = 2;

        ProductOrder[] productOrders = new ProductOrder[]{productOrder1, productOrder2, productOrder3};
        int sum = 0;
        for (ProductOrder m : productOrders) {
            System.out.printf("상품명 : %s, 가격 : %d, 수량 : %d%n", m.productName, m.price, m.quantity);
            sum += m.price * m.quantity;
        }
        System.out.printf("총 결제 금액 : %d", sum);
    }
}
