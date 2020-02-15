package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private static final String SALES_TAX = "Sales Tax";
    private static final String TOTAL_AMOUNT = "Total Amount";
    private Order order;
    private StringBuilder receiptOutput;
    private double totSalesTx = 0d;
    private double tot = 0d;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        receiptOutput = new StringBuilder();
        addRareceiptOutputStringbuilder();
        return receiptOutput.toString();
    }

    private void addRareceiptOutputStringbuilder() {
        addHeaders();
        addCustomerInfo();
        addLineItems();
        addTheStateTax(SALES_TAX, totSalesTx);
        addTheStateTax(TOTAL_AMOUNT, tot);
    }

    private void addTheStateTax(String s, double totSalesTx) {
        receiptOutput.append(s).append('\t').append(totSalesTx);
    }

    private void addLineItems() {
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
    }

    private void addCustomerInfo() {
        receiptOutput.append(order.getCustomerName());
        receiptOutput.append(order.getCustomerAddress());
    }

    private void addHeaders() {
        receiptOutput.append("======Printing Orders======\n");
    }

    private double getTot(LineItem lineItem) {
        return lineItem.totalAmount() + getSalesTax(lineItem);
    }

    private double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }
}
