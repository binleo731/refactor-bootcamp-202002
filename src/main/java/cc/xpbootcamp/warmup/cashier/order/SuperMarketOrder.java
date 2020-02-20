package cc.xpbootcamp.warmup.cashier.order;

import cc.xpbootcamp.warmup.cashier.LineItem;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SuperMarketOrder implements Order {
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
        return date.contains("星期三");
    }

    public double getDiscount() {
        return 0.98;
    }
}
