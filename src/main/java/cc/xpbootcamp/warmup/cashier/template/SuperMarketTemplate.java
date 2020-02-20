package cc.xpbootcamp.warmup.cashier.template;

import cc.xpbootcamp.warmup.cashier.LineItem;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SuperMarketTemplate implements Template {
    private static final String NOT_DISCOUNT = "0.00";
    private static final String HEADER = "===== 老王超市，值得信赖 ======";
    private static final String DIVIDER = "-----------------------------------";
    private static final String TAX_S = "税额: %s\n";
    private static final String DISCOUNT_S = "折扣: %s\n";
    private static final String TOTAL_PRICE_S = "总价: %s";
    private StringBuilder stringBuilder;

    @Override
    public String getTemplate(List<LineItem> lineItems, String tax, String discount, String totalPrice) {
        stringBuilder = new StringBuilder();
        addHeader();
        addLineItems(lineItems);
        addFooter(tax, discount, totalPrice);
        return stringBuilder.toString();
    }

    private void addLineItems(List<LineItem> lineItems) {
        for (LineItem lineItem : lineItems) {
            String lineItemFormat = String.format("%s,%s x %d,%s\n",
                    lineItem.getDescription(),
                    String.format("%.2f", lineItem.getPrice()),
                    lineItem.getQuantity(),
                    String.format("%.2f", lineItem.totalAmount()));
            stringBuilder.append(lineItemFormat);
        }
    }

    private void addHeader() {
        stringBuilder.append(String.format("%s\n\n", HEADER));
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        String date = df.format(new Date());
        stringBuilder.append(String.format("%s\n\n", date));
    }

    private void addFooter(String tax, String discount, String totalPrice) {
        stringBuilder.append(String.format("%s\n", DIVIDER));
        stringBuilder.append(String.format(TAX_S, tax));
        if (!NOT_DISCOUNT.equals(discount)) {
            stringBuilder.append(String.format(DISCOUNT_S, discount));
        }
        stringBuilder.append(String.format(TOTAL_PRICE_S, totalPrice));
    }
}
