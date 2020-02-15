package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receiptOutput = new StringBuilder();

        // print headers
        receiptOutput.append("======Printing Orders======\n");

        receiptOutput.append(order.getCustomerName());
        receiptOutput.append(order.getCustomerAddress());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receiptOutput.append(lineItem.getDescription());
            receiptOutput.append('\t');
            receiptOutput.append(lineItem.getPrice());
            receiptOutput.append('\t');
            receiptOutput.append(lineItem.getQuantity());
            receiptOutput.append('\t');
            receiptOutput.append(lineItem.totalAmount());
            receiptOutput.append('\n');
            // calculate sales tax @ rate of 10%
            totSalesTx += getSalesTax(lineItem);
            tot += getTot(lineItem);
        }

        // prints the state tax
        receiptOutput.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        receiptOutput.append("Total Amount").append('\t').append(tot);
        return receiptOutput.toString();
    }

    private double getTot(LineItem lineItem) {
        return lineItem.totalAmount() + getSalesTax(lineItem);
    }

    private double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }
}
