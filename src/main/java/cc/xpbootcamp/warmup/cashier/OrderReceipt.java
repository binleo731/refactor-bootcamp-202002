package cc.xpbootcamp.warmup.cashier;

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
    private static final double DOUBLE = .10;
    private double totalPrice = 0d;
    private double tax = 0d;

    public OrderReceipt(Order order, Template template) {
        this.order = order;
        this.template = template;
    }

    public String printReceipt() {
        calculate();
        return template.getTemplate(order.getLineItems(), tax, 0, totalPrice);
    }

    private void calculate() {
        for (LineItem lineItem : order.getLineItems()) {
            tax += lineItem.totalAmount() * DOUBLE;
            totalPrice += lineItem.totalAmount() + lineItem.totalAmount() * DOUBLE;
        }
    }
}
