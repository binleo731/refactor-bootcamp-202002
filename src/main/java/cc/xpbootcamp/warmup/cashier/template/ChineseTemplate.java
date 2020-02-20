package cc.xpbootcamp.warmup.cashier.template;

import cc.xpbootcamp.warmup.cashier.LineItem;

import java.util.Date;
import java.util.List;

public class ChineseTemplate implements Template {
    private static final String HEADER = "===== 老王超市，值得信赖 ======";
    private static final String DIVIDER = "-----------------------------------";
    private static final String TAX_S = "税额: %s\n";
    private static final String DISCOUNT_S = "折扣: %s\n";
    private static final String TOTAL_PRICE_S = "总价: %s";
    private StringBuilder stringBuilder;

    @Override
    public String getTemplate(List<LineItem> lineItems, double tax, double discount, double totalPrice) {
        stringBuilder = new StringBuilder();
        addHeader();
        addLineItems(lineItems);
        addFooter(tax, discount, totalPrice);
        return stringBuilder.toString();
    }

    private void addLineItems(List<LineItem> lineItems) {
        for (LineItem lineItem : lineItems) {
            String lineItemFormat = String.format("%s,%fx%d,%f\n",
                    lineItem.getDescription(),
                    lineItem.getPrice(),
                    lineItem.getQuantity(),
                    lineItem.totalAmount());
            stringBuilder.append(lineItemFormat);
        }
    }

    private void addHeader() {
        stringBuilder.append(String.format("%s\n\n", HEADER));
        stringBuilder.append(String.format("%s\n\n", new Date()));
    }

    private void addFooter(double tax, double discount, double totalPrice) {
        stringBuilder.append(String.format("%s\n\n", DIVIDER));
        stringBuilder.append(String.format(TAX_S, tax));
        if (discount != 0) {
            stringBuilder.append(String.format(DISCOUNT_S, discount));
        }
        stringBuilder.append(String.format(TOTAL_PRICE_S, totalPrice));
    }
}
