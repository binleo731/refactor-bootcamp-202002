package cc.xpbootcamp.warmup.cashier.order;

import cc.xpbootcamp.warmup.cashier.LineItem;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SuperMarketOrder implements Order {
    private static final String DISCOUNT_DAY = "星期三";
    private static final double DISCOUNT = 0.98;
    private List<LineItem> lineItemList;

    public SuperMarketOrder(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public boolean isDiscount() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        String date = df.format(new Date());
        return date.contains(DISCOUNT_DAY);
    }

    public double getDiscount() {
        return DISCOUNT;
    }
}
