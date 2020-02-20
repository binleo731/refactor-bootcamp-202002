package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.order.Order;
import cc.xpbootcamp.warmup.cashier.order.SuperMarketOrder;
import cc.xpbootcamp.warmup.cashier.template.Template;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    private Order order;
    private Template template;
    private static final double RATE = .10;
    private double totalPrice = 0d;
    private double tax = 0d;
    private double discountPrice = 0d;

    public OrderReceipt(SuperMarketOrder order, Template template) {
        this.order = order;
        this.template = template;
    }

    public String printReceipt() {
        calculatePrice();
        return getTemplateString();
    }

    private String getTemplateString() {
        return template.getTemplate(order.getLineItems(),
                String.format("%.2f", tax),
                String.format("%.2f", discountPrice),
                String.format("%.2f", totalPrice));
    }

    private void calculatePrice() {
        for (LineItem lineItem : order.getLineItems()) {
            tax += lineItem.totalAmount() * RATE;
            totalPrice += lineItem.totalAmount() + lineItem.totalAmount() * RATE;
        }

        double afterDiscountTotalPrice = totalPrice * order.getDiscount();
        discountPrice = totalPrice - afterDiscountTotalPrice;
        totalPrice = afterDiscountTotalPrice;
    }
}
